package com.xnyesf.opinion.controller;

import com.xnyesf.opinion.model.OpinionData;
import com.xnyesf.opinion.model.Result;
import com.xnyesf.opinion.service.OpinionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:29
 * @description 舆情controller
 */
@Controller("/opinion")
@ResponseBody
public class OpinionController {

    @Autowired
    private OpinionDataService opinionDataService;

    @PostMapping(value = "/import")
    public Result<Boolean> importOpinion(@RequestBody OpinionData opinionData){

    }


}
