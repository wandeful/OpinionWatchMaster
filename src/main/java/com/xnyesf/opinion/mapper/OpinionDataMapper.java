package com.xnyesf.opinion.mapper;

import com.xnyesf.opinion.entity.OpinionDataDO;
import com.xnyesf.opinion.entity.OpinionDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpinionDataMapper {
    long countByExample(OpinionDataExample example);

    int deleteByExample(OpinionDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OpinionDataDO row);

    int insertSelective(OpinionDataDO row);

    List<OpinionDataDO> selectByExampleWithBLOBs(OpinionDataExample example);

    List<OpinionDataDO> selectByExample(OpinionDataExample example);

    OpinionDataDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") OpinionDataDO row, @Param("example") OpinionDataExample example);

    int updateByExampleWithBLOBs(@Param("row") OpinionDataDO row, @Param("example") OpinionDataExample example);

    int updateByExample(@Param("row") OpinionDataDO row, @Param("example") OpinionDataExample example);

    int updateByPrimaryKeySelective(OpinionDataDO row);

    int updateByPrimaryKeyWithBLOBs(OpinionDataDO row);

    int updateByPrimaryKey(OpinionDataDO row);
}