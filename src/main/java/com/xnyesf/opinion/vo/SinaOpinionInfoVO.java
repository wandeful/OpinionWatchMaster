package com.xnyesf.opinion.vo;

import com.xnyesf.opinion.model.KeywordInfo;
import lombok.Data;

import java.util.List;

/**
 * @author CaoLiangBin
 * @date 2024年12月10日 23:11
 * @description 新浪舆情信息展示VO
 */
@Data
public class SinaOpinionInfoVO {
    /**
     * 本月监控总数
     */
    private Long newMonthMonitorCount;

    /**
     * 上月监控总数
     */
    private Long lastMonthMonitorCount;

    /**
     * 环比增长
     */
    private Long monthGrowthCount;

    /**
     * 今日关联词词汇-并且可以推出今日高频词汇
     */
    private List<KeywordInfo> currDayKeywordInfoList;









}
