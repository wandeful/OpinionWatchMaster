package com.xnyesf.opinion.service.impl;

import com.alibaba.fastjson2.JSON;
import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.entity.OpinionDataExample;
import com.xnyesf.opinion.enums.DataSourceEnum;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.model.KeywordInfo;
import com.xnyesf.opinion.model.SinaOpinionInfo;
import com.xnyesf.opinion.service.SinaOpinionDataService;
import com.xnyesf.opinion.util.time.TimeCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author CaoLiangBin
 * @date 2024年12月21日 10:10
 */
@Service
public class SinaOpinionDataServiceImpl implements SinaOpinionDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SinaOpinionDataServiceImpl.class);

    @Autowired
    private OpinionDataMapper opinionDataMapper;

    @Value("${custom.sinaTopicPopularity.keywordShowCount}")
    private int keywordShowCount;

    @Value("${custom.sinaTopicPopularity.keywordShowDay}")
    private int keywordShowDay;

    @Override
    public SinaOpinionInfo queryOpinionInfo() {
        SinaOpinionInfo sinaOpinionInfo = new SinaOpinionInfo();

        //1. 查询本月新浪监控总数
        long currentMonthCount = queryCurrentMonthCount();
        sinaOpinionInfo.setNewMonthMonitorCount(currentMonthCount);

        //2. 查询上月新浪监控总数
        long lastMonthCount = queryLastMonthCount();
        sinaOpinionInfo.setLastMonthMonitorCount(lastMonthCount);

        //3. 计算环比增长
        double monthOnMonthGrowth = calculateMonthOnMonthGrowth(currentMonthCount, lastMonthCount);
        sinaOpinionInfo.setMonthGrowthCount(monthOnMonthGrowth);

        //4. 计算今日帖子数
        long currentDayCount = queryCurrentDayCount();
        sinaOpinionInfo.setTodayPostCount(currentDayCount);

        //5. 计算今日评论数
        long currentDayCommentCount = queryCurrentDayCommentCount();
        sinaOpinionInfo.setCommentCount(currentDayCommentCount);

        //6. 计算今日点赞数
        long currentDayLikeCount = queryCurrentDayLikeCount();
        sinaOpinionInfo.setLikeCount(currentDayLikeCount);

        //7. 计算关键词信息
        List<KeywordInfo> keywordInfos = queryCurrentDayKeywordInfoList();
        sinaOpinionInfo.setCurrDayKeywordInfoList(keywordInfos);

        return sinaOpinionInfo;
    }

    /**
     * 查询本月新浪监控总数
     * @return 本月新浪监控总数
     */
    private long queryCurrentMonthCount(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.SINA.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getCurrentMonthStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getCurrentMonthEndDate());
        return opinionDataMapper.countByExample(opinionDataExample);
    }

    /**
     * 查询上月新浪监控总数
     * @return 上月新浪监控总数
     */
    private long queryLastMonthCount(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.SINA.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getLastMonthStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getLastMonthEndDate());
        return opinionDataMapper.countByExample(opinionDataExample);
    }

    /**
     * 计算环比增长
     *
     * @param currentMonthCount 本月总数
     * @param lastMonthCount    上月总数
     * @return 环比增长率
     */
    private double calculateMonthOnMonthGrowth(long currentMonthCount, long lastMonthCount) {
        if (lastMonthCount == 0) {
            return 0;
        }
        return (currentMonthCount - lastMonthCount) / (double) lastMonthCount * 100;
    }

    /**
     * 计算今日帖子数
     * @return 今日帖子数
     */
    private long queryCurrentDayCount(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.SINA.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getCurrentDayStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getCurrentDayEndDate());
        return opinionDataMapper.countByExample(opinionDataExample);
    }

    /**
     * 计算今日评论数
     * @return 今日评论数
     */
    private long queryCurrentDayCommentCount(){
        long commentCount = 0;
        List<OpinionDataDO> opinionDataDOS = queryCurrentDayOpinionData();
        if(CollectionUtils.isEmpty(opinionDataDOS)) {
            //无评论，返回0
            return 0;
        }

        for (OpinionDataDO opinionDataDO : opinionDataDOS) {
            commentCount += opinionDataDO.getCommentCount();
        }
        return  commentCount;
    }

    /**
     * 计算今日点赞数
     * @return 今日点赞数
     */
    private long queryCurrentDayLikeCount(){
        long likeCount = 0;
        List<OpinionDataDO> opinionDataDOS = queryCurrentDayOpinionData();
        if(CollectionUtils.isEmpty(opinionDataDOS)) {
            return 0;
        }

        for (OpinionDataDO opinionDataDO : opinionDataDOS) {
            likeCount += opinionDataDO.getLikeCount();
        }
        return likeCount;
    }

    /**
     * 查询当日的舆情数据
     * @return 当日的舆情数据
     */
    private List<OpinionDataDO> queryCurrentDayOpinionData(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.SINA.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getCurrentDayStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getCurrentDayEndDate());
        return opinionDataMapper.selectByExampleWithBLOBs(opinionDataExample);
    }

    /**
     * 查询当日的关键词信息
     * @return 当日的关键词信息
     */
    private List<KeywordInfo> queryCurrentDayKeywordInfoList(){
        List<KeywordInfo> keywordInfoList = new ArrayList<>();
        List<OpinionDataDO> opinionDataDOS = queryCurrentDayOpinionData();
        if(CollectionUtils.isEmpty(opinionDataDOS)) {
            return new ArrayList<>();
        }

        //得到今日热点词汇
        Map<String, Map<Date, Long>> keywordInfoMap = getOpinionDataKeywordInfo(opinionDataDOS);

        //通过热点词汇反推历史这些热点词汇的信息（包含本日信息）
        Map<String, Map<Date, Long>> allKeywordInfoMap = reverseTraceTodayAndHistoricalInfo(keywordInfoMap);

        for (Map.Entry<String, Map<Date, Long>> keywordInfoEntry : allKeywordInfoMap.entrySet()) {
            String keyword = keywordInfoEntry.getKey();
            Map<Date, Long> dateCountMap = keywordInfoEntry.getValue();
            KeywordInfo keywordInfo = new KeywordInfo();
            keywordInfo.setKeyword(keyword);
            keywordInfo.setDate2CountMap(dateCountMap);
            keywordInfoList.add(keywordInfo);
        }
        return keywordInfoList;
    }

    /**
     * 获取舆情数据中的热点词汇
     * @param opinionDataDOList
     * @return 热点词汇
     */
    private Map<String, Map<Date, Long>> getOpinionDataKeywordInfo(List<OpinionDataDO> opinionDataDOList) {
        Map<String, Map<Date, Long>> keywordInfoMap = new HashMap<>();
        for (OpinionDataDO opinionDataDO : opinionDataDOList) {
            String keyWordListStr = opinionDataDO.getKeyWordList();
            List<String> keywordList = JSON.parseArray(keyWordListStr, String.class);
            if(!CollectionUtils.isEmpty(keywordList)) {
                for (String keyword : keywordList) {
                    keywordInfoMap.computeIfAbsent(keyword, k-> new HashMap<>());
                    Date startOfDay = TimeCommonUtil.reset2StartOfDay(opinionDataDO.getGmtCreate());
                    keywordInfoMap.computeIfPresent(keyword, (k, v) ->
                    {
                        v.put(startOfDay, v.getOrDefault(startOfDay, 0l) + 1);
                        return v;
                    });
                }
            }
        }
        return keywordInfoMap;
    }



    /**
     * 查询某天的舆情数据
     * @param date 日期
     * @return 某天的舆情数据
     */
    private List<OpinionDataDO> queryOpinionDataByDate(Date date){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.SINA.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.reset2StartOfDay(date));
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.reset2EndOfDay(date));
        return opinionDataMapper.selectByExampleWithBLOBs(opinionDataExample);

    }


    /**
     * 反推今天热点词的历史信息
     * @param todayKeywordInfo
     * @return
     */
    private Map<String, Map<Date, Long>> reverseTraceTodayAndHistoricalInfo(Map<String, Map<Date, Long>> todayKeywordInfo) {
        if(CollectionUtils.isEmpty(todayKeywordInfo)) {
            return new HashMap<>();
        }

        Map<String, Map<Date, Long>> historyMap = new HashMap<>(todayKeywordInfo);
        //将配置中设置的要展示的距离今天的历史天数的舆情数据全部拿出来
        for(int subDay = 1; subDay < keywordShowDay; subDay++) {
            Date date = TimeCommonUtil.subDate(new Date(), subDay);
            List<OpinionDataDO> subDayOpinionDataDOList = queryOpinionDataByDate(date);
            Map<String, Map<Date, Long>> opinionDataKeywordInfo = getOpinionDataKeywordInfo(subDayOpinionDataDOList);
            historyMap = mergeMetricsBasedOnPrimary(historyMap, opinionDataKeywordInfo);
        }

        return historyMap;

    }

    private Map<String, Map<Date, Long>> mergeMetricsBasedOnPrimary(
            Map<String, Map<Date, Long>> primaryMetrics,
            Map<String, Map<Date, Long>> secondaryMetrics) {
        Map<String, Map<Date, Long>> mergedMetrics = new HashMap<>();

        // 遍历主要指标数据作为基准
        for (Map.Entry<String, Map<Date, Long>> entry : primaryMetrics.entrySet()) {
            String metricKey = entry.getKey();
            Map<Date, Long> primaryDateValues = entry.getValue();
            Map<Date, Long> mergedDateValues = new HashMap<>(primaryDateValues);

            // 检查次要指标数据中是否存在相同的指标键
            Map<Date, Long> secondaryDateValues = secondaryMetrics.get(metricKey);
            if (secondaryDateValues != null) {
                // 只合并主要指标中存在的日期数据
                for (Date date : primaryDateValues.keySet()) {
                    if (secondaryDateValues.containsKey(date)) {
                        // 如果两组数据中都存在该日期，则将值相加
                        mergedDateValues.put(date,
                                primaryDateValues.get(date) + secondaryDateValues.get(date));
                    }
                }
            }

            mergedMetrics.put(metricKey, mergedDateValues);
        }

        return mergedMetrics;
    }

}
