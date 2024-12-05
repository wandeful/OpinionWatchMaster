package com.xnyesf.opinion.service.impl;

import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.model.OpinionData;
import com.xnyesf.opinion.service.OpinionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:55
 */
@Service
public class OpinionDataServiceImpl implements OpinionDataService {
     @Autowired
     private OpinionDataMapper opinionDataMapper;

    @Override
    public void importOpinionData(OpinionData opinionData) {

    }
}
