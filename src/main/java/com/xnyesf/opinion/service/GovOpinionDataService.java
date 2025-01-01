package com.xnyesf.opinion.service;

import com.xnyesf.opinion.model.GovOpinionInfo;

/**
 * @Author CaoLiangBin
 * @Date 2024/12/28 10:22
 * @Version 1.0
 * @description 政府舆情数据服务
 */
public interface GovOpinionDataService {
    /**
     * 查询舆情信息
     * @return 舆情信息
     */
    GovOpinionInfo queryOpinionInfo();
}
