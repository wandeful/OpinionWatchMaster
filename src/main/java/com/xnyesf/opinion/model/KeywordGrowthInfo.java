package com.xnyesf.opinion.model;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author CaoLiangBin
 * @date 2024年12月10日 23:31
 * @description 关键词增长信息
 */
@Data
public class KeywordGrowthInfo {
    /**
     * 关键词
     */
    private String keyword;

    /**
     * 日期-数量映射关系
     */
    private Map<Date, Long> date2CountMap;
}