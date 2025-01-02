package com.xnyesf.opinion.service;

import com.xnyesf.opinion.model.OpinionData;
import com.xnyesf.opinion.model.OpinionStatisticsInfo;

import java.util.List;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:49
 * @description 舆情数据操控服务
 */

public interface OpinionDataService {

    /**
     * 导入舆情数据
     * @param opinionData 舆情数据
     * @return 插入Id
     */
    Long importOpinionData(OpinionData opinionData) throws Exception;

    /**
     * 批量导入舆情数据
     * @param opinionDataList
     * @return
     */
    List<Long> batchImportOpinionData(List<OpinionData> opinionDataList) throws Exception;

    /**
     * 查询舆情统计信息
     * @return 舆情统计信息
     */
    OpinionStatisticsInfo queryStatisticsInfo();
}
