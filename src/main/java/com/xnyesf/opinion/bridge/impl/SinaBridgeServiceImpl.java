package com.xnyesf.opinion.bridge.impl;

import com.xnyesf.opinion.bridge.SinaBridgeService;
import com.xnyesf.opinion.entity.*;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.mapper.SinaCommentsMapper;
import com.xnyesf.opinion.mapper.SinaMainBodyMapper;
import com.xnyesf.opinion.util.convert.OpinionDataConvertUtil;
import com.xnyesf.opinion.util.log.LogUtil;
import com.xnyesf.opinion.util.scheduler.TimeFramework;
import com.xnyesf.opinion.util.time.TimeCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author CaoLiangBin
 * @date 2025年01月02日 23:21
 */
@Service
public class SinaBridgeServiceImpl implements SinaBridgeService, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(SinaBridgeServiceImpl.class);

    private static final Integer INIT_DELAY = 0;

    private static final Integer INIT_PERIOD = 1;

    private static final Logger LOGGER = LoggerFactory.getLogger(CzNewsBridgeServiceImpl.class);

    @Autowired
    private OpinionDataMapper opinionDataMapper;

    @Autowired
    private TimeFramework timeFramework;

    @Autowired
    private SinaMainBodyMapper sinaMainBodyMapper;

    @Autowired
    private SinaCommentsMapper sinaCommentsMapper;
    @Autowired
    private SinaBridgeService sinaBridgeService;

    @Override
    public void bridgeData() {
        timeFramework.scheduleAtFixedRate(() -> {
            LogUtil.info(LOGGER,"sina data bridge start in date: {%s}", new Date().toString());
            SinaMainBodyExample sinaMainBodyExample = new SinaMainBodyExample();
            SinaMainBodyExample.Criteria criteria = sinaMainBodyExample.createCriteria();
            criteria.andReleaseTimeGreaterThanOrEqualTo(TimeCommonUtil.getCurrentDayStartDate());
            criteria.andReleaseTimeLessThanOrEqualTo(TimeCommonUtil.getCurrentDayEndDate());
            List<SinaMainBodyDO> sinaMainBodyDOS = sinaMainBodyMapper.selectByExampleWithBLOBs(sinaMainBodyExample);
            //以主体数据代表新浪数据，而不是评论信息
            LogUtil.info(LOGGER, "sina data count:{%s},date:{%s}", String.valueOf(sinaMainBodyDOS.size()), new Date().toString());

            List<String> blogIdList = sinaMainBodyDOS.stream().map(SinaMainBodyDO::getBlogId).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(blogIdList)) {
               return;
            }
            SinaCommentsExample sinaCommentsExample = new SinaCommentsExample();
            SinaCommentsExample.Criteria commentCriteria = sinaCommentsExample.createCriteria();
            commentCriteria.andBlogIdIn(blogIdList);
            List<SinaCommentsDO> sinaCommentsDOS = sinaCommentsMapper.selectByExample(sinaCommentsExample);
            Map<String, List<SinaCommentsDO>> sinaCommentMap = sinaCommentsDOS.stream()
                    .collect(Collectors.groupingBy(SinaCommentsDO::getBlogId));

            //以主体数据为主导
            sinaMainBodyDOS.forEach(sinaMainBodyDO -> {
                OpinionDataDO opinionDataDO = OpinionDataConvertUtil.convertSinaDO2OpinionDataDO(sinaMainBodyDO, sinaCommentMap.get(sinaMainBodyDO.getBlogId()));
                opinionDataMapper.insert(opinionDataDO);
            });

            LogUtil.info(LOGGER, String.join("sina bridge end in date: {%s}", new Date().toString()));

        }, INIT_DELAY, INIT_PERIOD, TimeUnit.DAYS);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        bridgeData();
    }
}
