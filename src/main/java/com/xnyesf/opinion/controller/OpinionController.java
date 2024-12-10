package com.xnyesf.opinion.controller;

import com.alibaba.fastjson2.JSON;
import com.xnyesf.opinion.model.OpinionData;
import com.xnyesf.opinion.model.Result;
import com.xnyesf.opinion.service.OpinionDataService;
import com.xnyesf.opinion.util.log.LogUtil;
import com.xnyesf.opinion.vo.SinaOpinionInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 导入单条舆情数据
     * @param opinionData
     * @return
     */
    @PostMapping(value = "/security/import.json")
    public Result<Long> importOpinion(@RequestBody OpinionData opinionData){
        try {
            if(opinionData == null){
                LogUtil.error(LOGGER, "insert null opinion data");
            }
            Long insertId = opinionDataService.importOpinionData(opinionData);
            LogUtil.info(LOGGER, "import opinion data success, opinionDataId:{%l}", insertId);
            return Result.success(insertId);
        } catch (Exception e){
            LogUtil.error(LOGGER, e, "import opinion data error, opinionData:{%s}", JSON.toJSONString(opinionData));
            return Result.error(e.getMessage());
        }
    }

    /**
     * 鼻梁导入舆情数据
     * @param opinionDataList
     * @return
     */
    @PostMapping(value = "/security/batch/import.json")
    public Result<List<Long>> batchImportOpinion(@RequestBody List<OpinionData> opinionDataList) {
        if(CollectionUtils.isEmpty(opinionDataList)){
            LogUtil.error(LOGGER, "insert null opinion data list");
        }
        try {
            List<Long> batchInsertId = opinionDataService.batchImportOpinionData(opinionDataList);
            LogUtil.info(LOGGER, "batch import opinion data success, opinionDataIdList:%s", JSON.toJSONString(opinionDataList));
            return Result.success(batchInsertId);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e, "batch import opinion data error, opinionDataList:{%s}", JSON.toJSONString(opinionDataList));
            return Result.error(e.getMessage());
        }
    }

    public SinaOpinionInfoVO querySinaInfo(){

    }




}