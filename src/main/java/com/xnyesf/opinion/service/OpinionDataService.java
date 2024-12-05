package com.xnyesf.opinion.service;

import com.xnyesf.opinion.model.OpinionData;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:49
 * @description 舆情数据操控服务
 */

public interface OpinionDataService {

    /**
     * 导入舆情数据
     * @param opinionData 舆情数据
     */
    void importOpinionData(OpinionData opinionData);
}
