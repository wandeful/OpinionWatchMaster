package com.xnyesf.opinion.bridge.impl;

import com.xnyesf.opinion.bridge.CzNewsBridgeService;
import com.xnyesf.opinion.entity.CzNewsDO;
import com.xnyesf.opinion.entity.CzNewsExample;
import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.mapper.CzNewsMapper;
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
public class CzNewsBridgeServiceImpl implements CzNewsBridgeService, InitializingBean {
    private static final Integer INIT_DELAY = 0;

    private static final Integer INIT_PERIOD = 1;

    private static final Logger LOGGER = LoggerFactory.getLogger(CzNewsBridgeServiceImpl.class);

    @Autowired
    private OpinionDataMapper opinionDataMapper;

    @Autowired
    private TimeFramework timeFramework;

    @Autowired
    private CzNewsMapper czNewsMapper;


    @Override
    public void bridgeData() {
        timeFramework.scheduleAtFixedRate(() -> {
            LogUtil.info(LOGGER, "chen zhou news bridge start in date: {%s}", new Date().toString());
            CzNewsExample czNewsExample = new CzNewsExample();
            CzNewsExample.Criteria criteria = czNewsExample.createCriteria();
            criteria.andReleaseDateGreaterThanOrEqualTo(TimeCommonUtil.getCurrentDayStartDate());
            criteria.andReleaseDateLessThanOrEqualTo(TimeCommonUtil.getCurrentDayEndDate());
            List<CzNewsDO> czNewsDOS = czNewsMapper.selectByExampleWithBLOBs(czNewsExample);

            LogUtil.info(LOGGER, "chen zhou news data count:{%s},date:{%s}", String.valueOf(czNewsDOS.size()), new Date().toString());
            czNewsDOS.forEach(czNewsDO -> {
                OpinionDataDO opinionDataDO = OpinionDataConvertUtil.convertCzNewsDO2OpinionDataDO(czNewsDO);
                opinionDataMapper.insert(opinionDataDO);
            });

            LogUtil.info(LOGGER,"chen zhou news bridge end in date: {%s}", new Date().toString());

        }, INIT_DELAY, INIT_PERIOD, TimeUnit.DAYS);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        bridgeData();
    }
}
