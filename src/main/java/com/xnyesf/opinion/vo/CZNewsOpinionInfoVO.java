package com.xnyesf.opinion.vo;

import com.xnyesf.opinion.model.KeywordGrowthInfo;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author CaoLiangBin
 * @Date 2024/12/30 13:59
 * @Version 1.0
 * @Description: 郴州新闻网舆情信息VO
 */
@Data
public class CZNewsOpinionInfoVO {
    /**
     * 关键词-占比映射关系
     */
    Map<String, Double> keyword2RatioMap;

    /**
     * 关键词增长信息
     */
    List<KeywordGrowthInfo> keywordGrowthInfoList;



}
