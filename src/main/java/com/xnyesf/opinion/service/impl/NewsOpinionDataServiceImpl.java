package com.xnyesf.opinion.service.impl;

import com.alibaba.fastjson2.JSON;
import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.entity.OpinionDataExample;
import com.xnyesf.opinion.enums.DataSourceEnum;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.model.CzNewsOpinionInfo;
import com.xnyesf.opinion.model.KeywordGrowthInfo;
import com.xnyesf.opinion.service.NewsOpinionDataService;
import com.xnyesf.opinion.util.time.TimeCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author CaoLiangBin
 * @Date 2024/12/28 10:26
 * @Version 1.0
 */
@Service
public class NewsOpinionDataServiceImpl implements NewsOpinionDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsOpinionDataServiceImpl.class);

    @Autowired
    private OpinionDataMapper opinionDataMapper;

    @Value("${custom.czNewsInfoConfig.keywordShowCount}")
    private int keywordShowCount;

    @Value("${custom.czNewsInfoConfig.keywordShowMonth}")
    private int keywordShowMonth;

    @Override
    public CzNewsOpinionInfo queryOpinionInfo() {
        CzNewsOpinionInfo czNewsOpinionInfo = new CzNewsOpinionInfo();
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.CHEN_ZHOU_NEWS.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getCurrentDayStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getCurrentDayEndDate());
        List<OpinionDataDO> opinionDataList = opinionDataMapper.selectByExampleWithBLOBs(opinionDataExample);

        //1. 填充本日关键词占比信息
        Map<String, Double> keywordRatio = computeKeywordRatio(opinionDataList);
        czNewsOpinionInfo.setKeyword2RatioMap(keywordRatio);

        //2. 计算关键词增长信息
        if (!CollectionUtils.isEmpty(opinionDataList)) {
            List<String> currentDayKeywordList = opinionDataList.stream().map(opinionDataDO -> {
                String keyWordListStr = opinionDataDO.getKeyWordList();
                return JSON.parseArray(keyWordListStr, String.class);
            }).flatMap(List::stream).collect(Collectors.toList());
            List<KeywordGrowthInfo> keywordGrowthInfoList = computeKeywordGrowthInfo(currentDayKeywordList);
            czNewsOpinionInfo.setKeywordGrowthInfoList(keywordGrowthInfoList);
        } else {
            czNewsOpinionInfo.setKeywordGrowthInfoList(new ArrayList<>());
        }
        return czNewsOpinionInfo;
    }

    /**
     * 填充关键词占比信息
     *
     * @param opinionDataList 舆情数据列表
     * @return 关键词占比信息
     */
    private Map<String, Double> computeKeywordRatio(List<OpinionDataDO> opinionDataList) {
        if (CollectionUtils.isEmpty(opinionDataList)) {
            return new HashMap<>();
        }
        //比例map
        Map<String, Double> keyword2RatioMap = new HashMap<>();
        //统计map
        Map<String, Long> keyword2CountMap = new HashMap<>();

        long totalCount = 0;

        //关键词总量
        for (OpinionDataDO opinionDataDO : opinionDataList) {
            String keyWordListStr = opinionDataDO.getKeyWordList();
            List<String> keywordList = JSON.parseArray(keyWordListStr, String.class);
            totalCount += keywordList.size();
            for (String keyword : keywordList) {
                keyword2CountMap.put(keyword, keyword2CountMap.getOrDefault(keyword, 0L) + 1);
            }
        }

        for (Map.Entry<String, Long> keyword2CountEntry : keyword2CountMap.entrySet()) {
            String keyword = keyword2CountEntry.getKey();
            Long count = keyword2CountEntry.getValue();
            if (totalCount != 0) {
                double ratio = (double) count / totalCount;
                keyword2RatioMap.put(keyword, ratio);
            }
        }

        return getTopN(keyword2RatioMap, keywordShowCount);
    }

    /**
     * 计算郴州新闻增长日期
     *
     * @param keywordList
     * @return
     */
    private List<KeywordGrowthInfo> computeKeywordGrowthInfo(List<String> keywordList) {
        if (CollectionUtils.isEmpty(keywordList)) {
            return new ArrayList<>();
        }
        Map<String, KeywordGrowthInfo> growthInfoMap = new HashMap<>();
        for (int retainMonth = 0; retainMonth < keywordShowMonth; retainMonth++) {
            //获得这个月的起始时间，用来标识关键词的月份
            Date distanceMonthStartDate = TimeCommonUtil.getDistanceMonthStartDate(retainMonth);
            Map<String, Long> keyword2CountForMonth = getKeyword2CountForMonth(retainMonth);
            keyword2CountForMonth.entrySet().stream()
                    .filter(entry -> keywordList.contains(entry.getKey()))
                    .forEach(entry -> {
                        String keyword = entry.getKey();
                        KeywordGrowthInfo keywordGrowthInfo = growthInfoMap.getOrDefault(keyword, new KeywordGrowthInfo());
                        keywordGrowthInfo.setKeyword(keyword);
                        Map<Date, Long> date2CountMap = keywordGrowthInfo.getDate2CountMap();
                        if (date2CountMap == null) {
                            date2CountMap = new HashMap<>();
                        }
                        Long count = entry.getValue();
                        date2CountMap.put(distanceMonthStartDate, count);
                        growthInfoMap.put(keyword, keywordGrowthInfo);
                    });

        }

        return new ArrayList<>(growthInfoMap.values());
    }

    private Map<String, Long> getKeyword2CountForMonth(int month) {
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.CHEN_ZHOU_NEWS.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getDistanceMonthStartDate(month));
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getDistanceMonthEndDate(month));
        List<OpinionDataDO> opinionDataDOS = opinionDataMapper.selectByExampleWithBLOBs(opinionDataExample);

        Map<String, Long> keyword2Count = new HashMap<>();
        for (OpinionDataDO opinionDataDO : opinionDataDOS) {
            String keywordListStr = opinionDataDO.getKeyWordList();
            List<String> keywordList = JSON.parseArray(keywordListStr, String.class);
            for (String keyword : keywordList) {
                keyword2Count.put(keyword, keyword2Count.getOrDefault(keyword, 0L) + 1);
            }
        }
        return keyword2Count;
    }

    private <K, V extends Number> Map<K, V> getTopN(Map<K, V> map, int n) {
        return map.entrySet().stream().sorted((e1, e2) -> {
            double v1 = e1.getValue().doubleValue();
            double v2 = e2.getValue().doubleValue();
            return Double.compare(v1, v2);
        }).limit(n).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new)
        );
    }


}
