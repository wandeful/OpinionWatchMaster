package com.xnyesf.opinion.service;

import com.xnyesf.opinion.model.CzNewsOpinionInfo;

/**
 * @Author CaoLiangBin
 * @Date 2024/12/28 10:23
 * @Version 1.0
 * @description 新闻舆情数据服务
 */
public interface NewsOpinionDataService {
    /**
     * 查询郴州新闻网旅游舆情信息
     * @return 郴州新闻网旅游舆情信息
     */
    CzNewsOpinionInfo queryOpinionInfo();

}
