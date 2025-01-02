package com.xnyesf.opinion.util.convert;

import com.alibaba.fastjson2.JSON;
import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.enums.DataSourceEnum;
import com.xnyesf.opinion.model.*;
import com.xnyesf.opinion.vo.CZNewsOpinionInfoVO;
import com.xnyesf.opinion.vo.GovOpinionInfoVO;
import com.xnyesf.opinion.vo.OpinionStatisticsInfoVO;
import com.xnyesf.opinion.vo.SinaOpinionInfoVO;

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

    /**
     * 转换新浪舆情信息为VO
     * @param sinaOpinionInfo 新浪舆情信息model
     * @return 新浪舆情信息VO
     */
    public static SinaOpinionInfoVO convert2VO(SinaOpinionInfo sinaOpinionInfo) {
        SinaOpinionInfoVO sinaOpinionInfoVO = new SinaOpinionInfoVO();
        sinaOpinionInfoVO.setCommentCount(sinaOpinionInfo.getCommentCount());
        sinaOpinionInfoVO.setLikeCount(sinaOpinionInfo.getLikeCount());
        sinaOpinionInfoVO.setLastMonthMonitorCount(sinaOpinionInfo.getLastMonthMonitorCount());
        sinaOpinionInfoVO.setMonthGrowthCount(sinaOpinionInfo.getMonthGrowthCount());
        sinaOpinionInfoVO.setNewMonthMonitorCount(sinaOpinionInfo.getNewMonthMonitorCount());
        sinaOpinionInfoVO.setTodayPostCount(sinaOpinionInfo.getTodayPostCount());
        sinaOpinionInfoVO.setCurrDayKeywordGrowthInfoList(sinaOpinionInfo.getCurrDayKeywordGrowthInfoList());
        return sinaOpinionInfoVO;
    }

    /**
     * 转换政府舆情信息为VO
     * @param govOpinionInfo
     */
    public static GovOpinionInfoVO convert2VO(GovOpinionInfo govOpinionInfo) {
        GovOpinionInfoVO govOpinionInfoVO = new GovOpinionInfoVO();
        govOpinionInfoVO.setOpinionTitleList(govOpinionInfo.getOpinionTitleList());
        govOpinionInfoVO.setCurrentMonthTotal(govOpinionInfo.getCurrentMonthTotal());
        govOpinionInfoVO.setLastMonthTotal(govOpinionInfo.getLastMonthTotal());
        govOpinionInfoVO.setBeforeLastMonthTotal(govOpinionInfo.getBeforeLastMonthTotal());
        return govOpinionInfoVO;
    }

    /**
     * 转换郴州新闻网舆情信息为VO
     * @param czNewsOpinionInfo
     * @return
     */
    public static CZNewsOpinionInfoVO convert2VO(CzNewsOpinionInfo czNewsOpinionInfo) {
        CZNewsOpinionInfoVO czNewsOpinionInfoVO = new CZNewsOpinionInfoVO();
        czNewsOpinionInfoVO.setKeyword2RatioMap(czNewsOpinionInfo.getKeyword2RatioMap());
        czNewsOpinionInfoVO.setKeywordGrowthInfoList(czNewsOpinionInfo.getKeywordGrowthInfoList());
        return czNewsOpinionInfoVO;
    }

    /**
     * 转换舆情统计信息为VO
     * @param opinionStatisticsInfo
     * @return 舆情统计信息VO
     */
    public static OpinionStatisticsInfoVO convert2VO(OpinionStatisticsInfo opinionStatisticsInfo) {
        OpinionStatisticsInfoVO opinionStatisticsInfoVO = new OpinionStatisticsInfoVO();
        opinionStatisticsInfoVO.setSinaHistoryTotal(opinionStatisticsInfo.getSinaHistoryTotal());
        opinionStatisticsInfoVO.setGovHistoryTotal(opinionStatisticsInfo.getGovHistoryTotal());
        opinionStatisticsInfoVO.setCzNewsHistoryTotal(opinionStatisticsInfo.getCzNewsHistoryTotal());
        opinionStatisticsInfoVO.setQuarterlyData(opinionStatisticsInfo.getQuarterlyData());
        return opinionStatisticsInfoVO;
    }
}
