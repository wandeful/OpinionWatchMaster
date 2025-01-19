package com.xnyesf.opinion.service.impl;

import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.entity.OpinionDataExample;
import com.xnyesf.opinion.enums.DataSourceEnum;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.model.GovOpinionInfo;
import com.xnyesf.opinion.service.GovOpinionDataService;
import com.xnyesf.opinion.util.time.TimeCommonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author CaoLiangBin
 * @Date 2024/12/28 10:25
 * @Version 1.0
 */
@Service
public class GovOpinionDataServiceImpl implements GovOpinionDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GovOpinionDataServiceImpl.class);

    @Autowired
    private OpinionDataMapper opinionDataMapper;

    @Value("${custom.govInfoConfig.titleLength}")
    private int titleLength;

    @Override
    public GovOpinionInfo queryOpinionInfo() {
        GovOpinionInfo govOpinionInfo = new GovOpinionInfo();

        //1. 查询本月舆情数量
        Date startDate = TimeCommonUtil.getCurrentMonthStartDate();
        Date endDate = TimeCommonUtil.getCurrentMonthEndDate();
        Long currentMonthTotal = queryOpinionDataCount(startDate, endDate);
        govOpinionInfo.setCurrentMonthTotal(currentMonthTotal);

        //2. 查询上月舆情数量
        startDate = TimeCommonUtil.getLastMonthStartDate();
        endDate = TimeCommonUtil.getLastMonthEndDate();
        Long lastMonthTotal = queryOpinionDataCount(startDate, endDate);
        govOpinionInfo.setLastMonthTotal(lastMonthTotal);

        //3. 查询上上月舆情数量
        startDate = TimeCommonUtil.getBeforeLastMonthStartDate();
        endDate = TimeCommonUtil.getBeforeLastMonthEndDate();
        Long beforeLastMonthTotal = queryOpinionDataCount(startDate, endDate);
        govOpinionInfo.setBeforeLastMonthTotal(beforeLastMonthTotal);

        //4. 查询舆情标题列表
        List<String> opinionDataTitleList = queryOpinionDataTitleList();
        govOpinionInfo.setOpinionTitleList(opinionDataTitleList);

        return govOpinionInfo;
    }

    /**
     * 查询时间范围内的舆情总量
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return 舆情总量
     */
    private Long queryOpinionDataCount(Date startDate, Date endDate) {
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.GOVERNMENT_PORTAL.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(startDate);
        criteria.andGmtCreateLessThanOrEqualTo(endDate);

        return opinionDataMapper.countByExample(opinionDataExample);
    }


    private List<String> queryOpinionDataTitleList() {
        List<String> opinionDataTitleList = new ArrayList<>();
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.GOVERNMENT_PORTAL.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getCurrentDayStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getCurrentDayEndDate());

        List<OpinionDataDO> opinionDataDOS = opinionDataMapper.selectByExample(opinionDataExample);
        if(CollectionUtils.isEmpty(opinionDataDOS)){
            return new ArrayList<>();
        }
        //注：怕存在文本没有标题，以及有的标题过长，因此统一使用配置长度
        for (OpinionDataDO opinionDataDO : opinionDataDOS) {
            String content = opinionDataDO.getContent();
            String title = truncateString(content, titleLength);
            opinionDataTitleList.add(title);
        }
        return opinionDataTitleList;
    }

    public static String truncateString(String input, int maxLength) {
        if (input == null || input.length() <= maxLength) {
            return input;
        }
        return input.substring(0, maxLength) + "...";
    }
}
