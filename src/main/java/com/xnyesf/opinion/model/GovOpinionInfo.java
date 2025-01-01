package com.xnyesf.opinion.model;

import lombok.Data;

import java.util.List;

/**
 * @Author CaoLiangBin
 * @Date 2024/12/28 14:55
 * @Version 1.0
 * @Description 政府舆情信息
 */
@Data
public class GovOpinionInfo {
    /**
     * 本月舆情总量
     */
    private Long currentMonthTotal;

    /**
     * 上月舆情总量
     */
    private Long lastMonthTotal;

    /**
     * 上上月舆情总量
     */
    private Long beforeLastMonthTotal;


    /**
     * 舆情标题列表
     */
    private List<String> opinionTitleList;


}
