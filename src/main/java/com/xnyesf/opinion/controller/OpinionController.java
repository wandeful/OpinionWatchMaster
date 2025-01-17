package com.xnyesf.opinion.controller;

import com.alibaba.fastjson2.JSON;
import com.xnyesf.opinion.model.*;
import com.xnyesf.opinion.service.GovOpinionDataService;
import com.xnyesf.opinion.service.NewsOpinionDataService;
import com.xnyesf.opinion.service.OpinionDataService;
import com.xnyesf.opinion.service.SinaOpinionDataService;
import com.xnyesf.opinion.util.convert.OpinionDataConvertUtil;
import com.xnyesf.opinion.util.log.LogUtil;
import com.xnyesf.opinion.vo.CZNewsOpinionInfoVO;
import com.xnyesf.opinion.vo.GovOpinionInfoVO;
import com.xnyesf.opinion.vo.SinaOpinionInfoVO;
import com.xnyesf.opinion.vo.OpinionStatisticsInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:29
 * @description 舆情controller
 */
@Controller
@RequestMapping("/opinion")
@ResponseBody
public class OpinionController {

    private static Logger LOGGER = LoggerFactory.getLogger(OpinionController.class);

    @Autowired
    private OpinionDataService opinionDataService;

    @Autowired
    private SinaOpinionDataService sinaOpinionDataService;

    @Autowired
    private GovOpinionDataService govOpinionDataService;

    @Autowired
    private NewsOpinionDataService newsOpinionDataService;

    /**
     * 导入单条舆情数据
     *
     * @param opinionData
     * @return
     */
    @PostMapping(value = "/security/import.json")
    public Result<Long> importOpinion(@RequestBody OpinionData opinionData) {
        try {
            if (opinionData == null) {
                LogUtil.error(LOGGER, "insert null opinion data");
                return Result.error("insert null opinion data");
            }
            Long insertId = opinionDataService.importOpinionData(opinionData);
            LogUtil.info(LOGGER, "import opinion data success, opinionDataId:{}", insertId);
            return Result.success(insertId);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e, "import opinion data error, opinionData:{}", JSON.toJSONString(opinionData));
            return Result.error(e.getMessage());
        }
    }

    /**
     * 批量导入舆情数据
     *
     * @param opinionDataList
     * @return
     */
    @PostMapping(value = "/security/batch/import.json")
    public Result<List<Long>> batchImportOpinion(@RequestBody List<OpinionData> opinionDataList) {
        if (CollectionUtils.isEmpty(opinionDataList)) {
            LogUtil.error(LOGGER, "insert null opinion data list");
            return Result.error("insert null opinion data list");
        }
        try {
            List<Long> batchInsertId = opinionDataService.batchImportOpinionData(opinionDataList);
            LogUtil.info(LOGGER, "batch import opinion data success, opinionDataIdList:{}", JSON.toJSONString(opinionDataList));
            return Result.success(batchInsertId);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e, "batch import opinion data error, opinionDataList:{}", JSON.toJSONString(opinionDataList));
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询新浪舆情信息
     *
     * @return 新浪舆情信息
     */
    @GetMapping(value = "/normal/querySinaInfo.json")
    public Result<SinaOpinionInfoVO> querySinaInfo() {
        try {
            SinaOpinionInfo opinionInfo = sinaOpinionDataService.queryOpinionInfo();
            if (opinionInfo == null) {
                LogUtil.info(LOGGER, "sina info is null");
                return Result.success(null);
            }
            SinaOpinionInfoVO sinaOpinionInfoVO = OpinionDataConvertUtil.convert2VO(opinionInfo);
            return Result.success(sinaOpinionInfoVO);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e, "query sina info error");
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询政府舆情信息
     *
     * @return 政府舆情信息
     */
    @GetMapping(value = "/normal/queryGovInfo.json")
    public Result<GovOpinionInfoVO> queryGovInfo() {
        try{
            GovOpinionInfo govOpinionInfo = govOpinionDataService.queryOpinionInfo();
            if(govOpinionInfo == null) {
                LogUtil.info(LOGGER, "government info is null");
                return Result.success(null);
            }
            GovOpinionInfoVO govOpinionInfoVO = OpinionDataConvertUtil.convert2VO(govOpinionInfo);
            return Result.success(govOpinionInfoVO);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e, "query gov info error");
            return Result.error(e.getMessage());
        }
    }

    @GetMapping(value = "/normal/ChenZhou/queryNewsInfo.json")
    public Result<CZNewsOpinionInfoVO> queryCZNewsInfo() {
        try{
            CzNewsOpinionInfo czNewsOpinionInfo = newsOpinionDataService.queryOpinionInfo();
            if(czNewsOpinionInfo == null){
                LogUtil.info(LOGGER, "chen zhou news info is null");
                return Result.success(null);
            }
            CZNewsOpinionInfoVO czNewsOpinionInfoVO = OpinionDataConvertUtil.convert2VO(czNewsOpinionInfo);
            return Result.success(czNewsOpinionInfoVO);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e, "query cz news info error");
            return Result.error(e.getMessage());
        }
    }

    @GetMapping(value = "/normal/querStatisticsInfo.json")
    public Result<OpinionStatisticsInfoVO> queryStatisticsInfo() {
        try{
            OpinionStatisticsInfo opinionStatisticsInfo = opinionDataService.queryStatisticsInfo();
            if(opinionStatisticsInfo == null){
                LogUtil.info(LOGGER, "statistics info is null");
                return Result.success(null);
            }
            OpinionStatisticsInfoVO opinionStatisticsInfoVO = OpinionDataConvertUtil.convert2VO(opinionStatisticsInfo);
            return Result.success(opinionStatisticsInfoVO);
        }catch (Exception e) {
            LogUtil.error(LOGGER, e, "query statistics info error");
            return Result.error(e.getMessage());
        }

    }




}
