package com.xnyesf.opinion.service.impl;

import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.entity.OpinionDataExample;
import com.xnyesf.opinion.enums.DataSourceEnum;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.model.CzNewsOpinionInfo;
import com.xnyesf.opinion.service.NewsOpinionDataService;
import com.xnyesf.opinion.util.time.TimeCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author CaoLiangBin
 * @Date 2024/12/28 10:26
 * @Version 1.0
 */
@Service
public class NewsOpinionDataServiceImpl implements NewsOpinionDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsOpinionDataServiceImpl.class);

    @Autowired
    private OpinionDataMapper  opinionDataMapper;

    @Override
    public CzNewsOpinionInfo queryOpinionInfo() {
        CzNewsOpinionInfo czNewsOpinionInfo = new CzNewsOpinionInfo();
        //1. 填充本日关键词占比信息
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.CHEN_ZHOU_NEWS.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getCurrentDayStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getCurrentDayEndDate());
        List<OpinionDataDO> opinionDataList = opinionDataMapper.selectByExample(opinionDataExample);
        Map<String, Double> keywordRatio = computeKeywordRatio(opinionDataList);
        czNewsOpinionInfo.setKeyword2RatioMap(keywordRatio);

        //2. 计算关键词增长信息


        return czNewsOpinionInfo;
    }

    /**
     * 填充关键词占比信息
     * @param opinionDataList 舆情数据列表
     * @return 关键词占比信息
     */
    private Map<String, Double> computeKeywordRatio(List<OpinionDataDO> opinionDataList) {
        if(CollectionUtils.isEmpty(opinionDataList)){
            return new HashMap<>();
        }
        Map<String, Double> keyword2RatioMap = new HashMap<>();
        opinionDataList.forEach(opinionDataDO -> {

        });
        return keyword2RatioMap;
    }


}
