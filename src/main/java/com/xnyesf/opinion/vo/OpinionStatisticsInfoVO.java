package com.xnyesf.opinion.vo;

import com.xnyesf.opinion.enums.DataSourceEnum;
import lombok.Data;

import java.util.Map;

/**
 * @author CaoLiangBin
 * @date 2025年01月02日 20:21
 * @description 舆情统计信息
 */
@Data
public class OpinionStatisticsInfoVO {
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
