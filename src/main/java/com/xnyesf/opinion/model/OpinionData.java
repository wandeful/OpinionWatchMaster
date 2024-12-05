package com.xnyesf.opinion.model;

import com.xnyesf.opinion.enums.DataSourceEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:24
 * @description 舆情数据领域模型
 */
@Data
public class OpinionData {
    /**
     * 自增主键id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 数据来源
     */
    private DataSourceEnum source;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 额外数据
     */
    private String extData;

    /**
     * 关键词列表
      */
    private List<String> keyWordList;

    /**
     * 文本内容
     */
    private String content;
}
