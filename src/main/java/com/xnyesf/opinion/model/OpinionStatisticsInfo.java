package com.xnyesf.opinion.model;

import com.xnyesf.opinion.enums.DataSourceEnum;
import lombok.Data;

import java.util.Map;

/**
 * @author CaoLiangBin
 * @date 2025年01月02日 20:52
 */
@Data
public class OpinionStatisticsInfo {
    /**
     * 新浪历史总数
     */
    Long sinaHistoryTotal;

    /**
     * 政府历史总数
     */
    Long govHistoryTotal;

    /**
     * 郴州新闻历史总数
     */
    Long czNewsHistoryTotal;

    /**
     * 季度数据
     */
    Map<DataSourceEnum, Double> quarterlyData;
}
