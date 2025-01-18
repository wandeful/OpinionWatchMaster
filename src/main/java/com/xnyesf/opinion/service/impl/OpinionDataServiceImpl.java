package com.xnyesf.opinion.service.impl;

import com.alibaba.fastjson2.JSON;
import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.entity.OpinionDataExample;
import com.xnyesf.opinion.enums.DataSourceEnum;
import com.xnyesf.opinion.mapper.OpinionDataMapper;
import com.xnyesf.opinion.model.OpinionData;
import com.xnyesf.opinion.model.OpinionStatisticsInfo;
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

import javax.sql.DataSource;
import java.util.*;
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
    @Autowired
    private DataSource dataSource;

    @Override
    public Long importOpinionData(OpinionData opinionData) throws Exception {
        importOpinionDataPreCheck(opinionData);
        OpinionDataDO opinionDataDO = OpinionDataConvertUtil.Convert2DO(opinionData);
        int insertFlag = opinionDataMapper.insert(opinionDataDO);
        if(insertFlag <= 0){
            throw new Exception(String.format("import opinion data error, opinionData:{%s}",
                    JSON.toJSONString(opinionDataDO)));
        }
        return opinionDataDO.getId();
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
            int insertFlag = opinionDataMapper.insert(opinionDataDO);
            if(insertFlag <= 0){
                throw new Exception(String.format("batch import opinion data error, opinionData:{%s}",
                        JSON.toJSONString(opinionDataDO)));
            }
            batchImportIdList.add(opinionDataDO.getId());
        }
        return batchImportIdList;
    }

    @Override
    public OpinionStatisticsInfo queryStatisticsInfo() {
        OpinionStatisticsInfo opinionStatisticsInfo = new OpinionStatisticsInfo();
        //1. 查询新浪历史总数
        Long sinaHistoryTotal = querySinaHistoryTotal();
        opinionStatisticsInfo.setSinaHistoryTotal(sinaHistoryTotal);

        //2. 查询政府历史总数
        Long govHistoryTotal = queryGovHistoryTotal();
        opinionStatisticsInfo.setGovHistoryTotal(govHistoryTotal);

        //3. 查询郴州新闻网历史总数
        Long czNewsHistoryTotal = queryCzNewsHistoryTotal();
        opinionStatisticsInfo.setCzNewsHistoryTotal(czNewsHistoryTotal);

        //4. 计算占比比例
        HashMap<DataSourceEnum, Long> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.SINA, sinaHistoryTotal);
        dataSourceMap.put(DataSourceEnum.GOVERNMENT_PORTAL, govHistoryTotal);
        dataSourceMap.put(DataSourceEnum.CHEN_ZHOU_NEWS, czNewsHistoryTotal);
        Map<DataSourceEnum, Double> proportionMap = computeComponentProportion(dataSourceMap);
        opinionStatisticsInfo.setQuarterlyData(proportionMap);

        return opinionStatisticsInfo;
    }

    private Long querySinaHistoryTotal(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.SINA.getSource());
        return opinionDataMapper.countByExample(opinionDataExample);
    }

    private Long queryGovHistoryTotal(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.GOVERNMENT_PORTAL.getSource());
        return opinionDataMapper.countByExample(opinionDataExample);
    }

    private Long queryCzNewsHistoryTotal(){
        OpinionDataExample opinionDataExample = new OpinionDataExample();
        OpinionDataExample.Criteria criteria = opinionDataExample.createCriteria();
        criteria.andSourceEqualTo(DataSourceEnum.CHEN_ZHOU_NEWS.getSource());
        return opinionDataMapper.countByExample(opinionDataExample);
    }

    private Map<DataSourceEnum, Double> computeComponentProportion(Map<DataSourceEnum, Long> sourceTotalMap){
        if(CollectionUtils.isEmpty(sourceTotalMap)){
            return Collections.emptyMap();
        }

        long total = sourceTotalMap.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
        return sourceTotalMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                    Map.Entry::getKey, entry -> (double) entry.getValue() / total)
                );

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
