package com.xnyesf.opinion.vo;

import com.xnyesf.opinion.model.KeywordGrowthInfo;
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
    private Double monthGrowthCount;

    //今日动态 start
    /**
     * 帖子数
     */
    private Long todayPostCount;

    /**
     * 评论数
     */
    private Long commentCount;

    /**
     * 点赞数
     */
    private Long likeCount;

    //今日动态 end

    /**
     * 可获取如下信息
     * 1. 今日关联词汇
     * 2. 今日高频词汇
     * 3. 词调热度指数，基于今日高频词汇推出该词汇前7日的数量，形成词条热度指数
     */
    private List<KeywordGrowthInfo> currDayKeywordGrowthInfoList;









}
