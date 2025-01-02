package com.xnyesf.opinion.bridge.impl;

import com.xnyesf.opinion.bridge.CzGovBridgeService;
import com.xnyesf.opinion.mapper.CzGovMapper;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.util.log.LogUtil;
import com.xnyesf.opinion.util.scheduler.TimeFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author CaoLiangBin
 * @date 2025年01月02日 23:20
 */
@Service
public class CzGovBridgeServiceImpl implements CzGovBridgeService {
    private static final Integer SCHEDULER_POOL_SIZE = 10;

    private static final Integer INIT_DELAY = 0;

    private static final Integer INIT_PERIOD = 1;

    private static final Logger LOGGER = LoggerFactory.getLogger(CzGovBridgeServiceImpl.class);

    @Autowired
    private CzGovMapper czGovMapper;

    @Autowired
    private OpinionDataMapper opinionDataMapper;

    @Override
    public void bridgeData() {
        TimeFramework timeFramework = new TimeFramework(SCHEDULER_POOL_SIZE);
        timeFramework.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LogUtil.info(LOGGER, String.join("chen zhou gov bridge start for date: {%s}", new Date().toString()));

            }
        }, INIT_DELAY, INIT_PERIOD, TimeUnit.DAYS);

    }
}
