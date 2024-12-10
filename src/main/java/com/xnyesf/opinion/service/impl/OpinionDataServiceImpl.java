package com.xnyesf.opinion.service.impl;

import com.alibaba.fastjson2.JSON;
import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.model.OpinionData;
import com.xnyesf.opinion.service.OpinionDataService;
import com.xnyesf.opinion.util.convert.OpinionDataConvertUtil;
import com.xnyesf.opinion.util.gen.UuidGenerator;
import com.xnyesf.opinion.util.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:55
 */
@Service
public class OpinionDataServiceImpl implements OpinionDataService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpinionDataServiceImpl.class);

     @Autowired
     private OpinionDataMapper opinionDataMapper;

    @Override
    public Long importOpinionData(OpinionData opinionData) throws Exception {
        importOpinionDataPreCheck(opinionData);
        OpinionDataDO opinionDataDO = OpinionDataConvertUtil.Convert2DO(opinionData);
        Long lastInsertId = (long) opinionDataMapper.insert(opinionDataDO);
        if(lastInsertId <= 0){
            throw new Exception(String.format("importOpinionData error, opinionData:{%s}",
                    JSON.toJSONString(opinionDataDO)));
        }
        return lastInsertId;
    }

    @Override
    public List<Long> batchImportOpinionData(List<OpinionData> opinionDataList) throws Exception {
        if(CollectionUtils.isEmpty(opinionDataList)){
            LogUtil.warn(LOGGER, "batch import opinion data List is empty");
            return Collections.emptyList();
        }
        List<OpinionDataDO> opinionDataDOList = opinionDataList.stream()
                .map(opinionData -> {
                    importOpinionDataPreCheck(opinionData);
                    return OpinionDataConvertUtil.Convert2DO(opinionData);
                })
                .collect(Collectors.toList());

        List<Long> batchImportIdList = new ArrayList<>();
        for (OpinionDataDO opinionDataDO : opinionDataDOList) {
            Long insertId = (long) opinionDataMapper.insert(opinionDataDO);
            batchImportIdList.add(insertId);
        }
        return batchImportIdList;
    }

    /**
     * 舆情数据预处理
     * @param opinionData 舆情数据
     * @return 预处理后的舆情数据
     */
    private void importOpinionDataPreCheck(OpinionData opinionData) {
        if(opinionData == null){
            return ;
        }
        if(StringUtils.isEmpty(opinionData.getUuid())) {
            opinionData.setUuid(UuidGenerator.generateUUID());
        }
        if(opinionData.getGmtCreate() == null) {
            //填充当前时间
            opinionData.setGmtCreate(new Date());
        }
        if(opinionData.getGmtModified() == null) {
            opinionData.setGmtModified(new Date());
        }
    }
}
