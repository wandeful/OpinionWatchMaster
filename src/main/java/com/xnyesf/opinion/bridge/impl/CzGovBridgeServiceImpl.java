package com.xnyesf.opinion.bridge.impl;

import com.xnyesf.opinion.bridge.CzGovBridgeService;
import com.xnyesf.opinion.entity.CzGovDO;
import com.xnyesf.opinion.entity.CzGovExample;
import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.mapper.CzGovMapper;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.util.convert.OpinionDataConvertUtil;
import com.xnyesf.opinion.util.log.LogUtil;
import com.xnyesf.opinion.util.scheduler.TimeFramework;
import com.xnyesf.opinion.util.time.TimeCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author CaoLiangBin
 * @date 2025年01月02日 23:20
 */
@Service
public class CzGovBridgeServiceImpl implements CzGovBridgeService, InitializingBean {
    private static final Integer INIT_DELAY = 0;

    private static final Integer INIT_PERIOD = 1;

    private static final Logger LOGGER = LoggerFactory.getLogger(CzGovBridgeServiceImpl.class);

    @Autowired
    private CzGovMapper czGovMapper;

    @Autowired
    private OpinionDataMapper opinionDataMapper;

    @Autowired
    private TimeFramework timeFramework;

    @Override
    public void bridgeData() {
        timeFramework.scheduleAtFixedRate(() -> {
            LogUtil.info(LOGGER, "chen zhou gov bridge start in date: {}", new Date().toString());
            CzGovExample czGovExample = new CzGovExample();
            CzGovExample.Criteria criteria = czGovExample.createCriteria();
            criteria.andReleaseTimeGreaterThanOrEqualTo(TimeCommonUtil.getCurrentDayStartDate());
            criteria.andReleaseTimeLessThanOrEqualTo(TimeCommonUtil.getCurrentDayEndDate());
            List<CzGovDO> czGovDOS = czGovMapper.selectByExampleWithBLOBs(czGovExample);

            LogUtil.info(LOGGER, "chen zhou gov data count:{},date:{}", String.valueOf(czGovDOS.size()), new Date().toString());
            czGovDOS.forEach(czGovDO -> {
                OpinionDataDO opinionDataDO = OpinionDataConvertUtil.convertCzGovDO2OpinionDataDO(czGovDO);
                opinionDataMapper.insert(opinionDataDO);
            });

            LogUtil.info(LOGGER,"chen zhou gov bridge end in date: {}", new Date().toString());

        }, INIT_DELAY, INIT_PERIOD, TimeUnit.DAYS);

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        //启动桥接定时任务
        bridgeData();
    }
}
