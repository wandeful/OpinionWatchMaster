package com.xnyesf.opinion.service;

import com.xnyesf.opinion.model.SinaOpinionInfo;

/**
 * @author CaoLiangBin
 * @date 2024年12月21日 9:55
 * @description: 新浪舆情数据操控服务
 */
public interface SinaOpinionDataService {
    /**
     * 查询新浪舆情数据
     * @return 新浪舆情数据
     */
    SinaOpinionInfo queryOpinionInfo();
}
