package com.xnyesf.opinion.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author CaoLiangBin
 * @Date 2024/12/30 14:18
 * @Version 1.0
 * @Description : 郴州新闻网舆情信息
 */
@Data
public class CzNewsOpinionInfo {
    /**
     * 关键词-占比映射关系
     */
    Map<String, Double> keyword2RatioMap;

    /**
     * 关键词增长信息
     */
    List<KeywordGrowthInfo> keywordGrowthInfoList;

}
