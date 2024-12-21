package com.xnyesf.opinion.service.impl;

import com.xnyesf.opinion.entity.OpinionDataExample;
import com.xnyesf.opinion.enums.DataSourceEnum;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.model.SinaOpinionInfo;
import com.xnyesf.opinion.service.SinaOpinionDataService;
import com.xnyesf.opinion.util.time.TimeCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CaoLiangBin
 * @date 2024年12月21日 10:10
 */
@Service
public class SinaOpinionDataServiceImpl implements SinaOpinionDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SinaOpinionDataServiceImpl.class);

    @Autowired
    private OpinionDataMapper opinionDataMapper;

    @Override
    public SinaOpinionInfo queryOpinionInfo() {
        SinaOpinionInfo sinaOpinionInfo = new SinaOpinionInfo();

        //1. 查询本月新浪监控总数
        long currentMonthCount = queryCurrentMonthCount();
        sinaOpinionInfo.setNewMonthMonitorCount(currentMonthCount);

        //2. 查询上月新浪监控总数
        long lastMonthCount = queryLastMonthCount();
        sinaOpinionInfo.setLastMonthMonitorCount(lastMonthCount);

        //3. 计算环比增长
        double monthOnMonthGrowth = calculateMonthOnMonthGrowth(currentMonthCount, lastMonthCount);
        sinaOpinionInfo.setMonthGrowthCount(monthOnMonthGrowth);

        //4. 计算今日帖子数


        //5. 计算今日评论数

        //6. 计算今日点赞数

        //7. 计算关键词信息

        return sinaOpinionInfo;
    }

    /**
     * 查询本月新浪监控总数
     * @return 本月新浪监控总数
     */
    private long queryCurrentMonthCount(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.SINA.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getCurrentMonthStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getCurrentMonthEndDate());
        return opinionDataMapper.countByExample(opinionDataExample);
    }

    /**
     * 查询上月新浪监控总数
     * @return 上月新浪监控总数
     */
    private long queryLastMonthCount(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.SINA.getSource());
        criteria.andGmtCreateGreaterThanOrEqualTo(TimeCommonUtil.getLastMonthStartDate());
        criteria.andGmtCreateLessThanOrEqualTo(TimeCommonUtil.getLastMonthEndDate());
        return opinionDataMapper.countByExample(opinionDataExample);
    }

    /**
     * 计算环比增长
     *
     * @param currentMonthCount 本月总数
     * @param lastMonthCount    上月总数
     * @return 环比增长率
     */
    private double calculateMonthOnMonthGrowth(long currentMonthCount, long lastMonthCount) {
        if (lastMonthCount == 0) {
            return 0;
        }
        return (currentMonthCount - lastMonthCount) / (double) lastMonthCount * 100;
    }

    /**
     * 计算今日帖子数
     * @return 今日帖子数
     */
    private long queryCurrentDayCount(){

    }

    /**
     * 计算今日评论数
     * @return 今日评论数
     */
    private long queryCurrentDayCommentCount(){

    }

    /**
     * 计算今日点赞数
     * @return 今日点赞数
     */
    private long queryCurrentDayLikeCount(){

    }



}
