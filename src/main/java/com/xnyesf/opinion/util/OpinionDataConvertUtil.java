package com.xnyesf.opinion.util;

import com.alibaba.fastjson2.JSON;
import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.enums.DataSourceEnum;
import com.xnyesf.opinion.model.OpinionData;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:58
 * @description 舆情数据转换工具类
 */
public class OpinionDataConvertUtil {
    /**
     * 转换model为DO
     * @param opinionData 舆情数据
     * @return 舆情数据DO
     */
    public static OpinionDataDO Convert2DO(OpinionData opinionData){
        OpinionDataDO opinionDataDO = new OpinionDataDO();
        opinionDataDO.setId(opinionData.getId());
        opinionDataDO.setUuid(opinionData.getUuid());
        opinionDataDO.setGmtCreate(opinionData.getGmtCreate());
        opinionDataDO.setGmtModified(opinionData.getGmtModified());
        opinionDataDO.setLikeCount(opinionData.getLikeCount());
        opinionDataDO.setCommentCount(opinionData.getCommentCount());
        opinionDataDO.setKeyWordList(JSON.toJSONString(opinionData.getKeyWordList()));
        opinionDataDO.setSource(opinionData.getSource().getSource());
        opinionDataDO.setContent(opinionData.getContent());
        opinionDataDO.setExtData(opinionData.getExtData());
        return opinionDataDO;
    }

    /**
     * 转换DO为Model
     * @param opinionDataDO 舆情数据DO
     * @return 舆情数据领域Model
     */
    public static OpinionData Convert2Model(OpinionDataDO opinionDataDO){
        OpinionData opinionData = new OpinionData();
        opinionData.setId(opinionDataDO.getId());
        opinionData.setUuid(opinionDataDO.getUuid());
        opinionData.setGmtCreate(opinionDataDO.getGmtCreate());
        opinionData.setGmtModified(opinionDataDO.getGmtModified());
        opinionData.setLikeCount(opinionDataDO.getLikeCount());
        opinionData.setCommentCount(opinionDataDO.getCommentCount());
        opinionData.setSource(DataSourceEnum.getBySource(opinionDataDO.getSource()));
        opinionData.setKeyWordList(JSON.parseArray(opinionDataDO.getKeyWordList(), String.class));
        opinionData.setContent(opinionDataDO.getContent());
        opinionData.setExtData(opinionDataDO.getExtData());
        return opinionData;
    }
}
