package com.xnyesf.opinion.mapper;

import com.xnyesf.opinion.entity.OpinionData;
import com.xnyesf.opinion.entity.OpinionDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpinionDataMapper {
    long countByExample(OpinionDataExample example);

    int deleteByExample(OpinionDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OpinionData row);

    int insertSelective(OpinionData row);

    List<OpinionData> selectByExampleWithBLOBs(OpinionDataExample example);

    List<OpinionData> selectByExample(OpinionDataExample example);

    OpinionData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") OpinionData row, @Param("example") OpinionDataExample example);

    int updateByExampleWithBLOBs(@Param("row") OpinionData row, @Param("example") OpinionDataExample example);

    int updateByExample(@Param("row") OpinionData row, @Param("example") OpinionDataExample example);

    int updateByPrimaryKeySelective(OpinionData row);

    int updateByPrimaryKeyWithBLOBs(OpinionData row);

    int updateByPrimaryKey(OpinionData row);
}