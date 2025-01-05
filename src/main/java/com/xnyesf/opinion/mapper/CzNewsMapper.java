package com.xnyesf.opinion.mapper;

import com.xnyesf.opinion.entity.CzNewsDO;
import com.xnyesf.opinion.entity.CzNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CzNewsMapper {
    long countByExample(CzNewsExample example);

    int deleteByExample(CzNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CzNewsDO row);

    int insertSelective(CzNewsDO row);

    List<CzNewsDO> selectByExampleWithBLOBs(CzNewsExample example);

    List<CzNewsDO> selectByExample(CzNewsExample example);

    CzNewsDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") CzNewsDO row, @Param("example") CzNewsExample example);

    int updateByExampleWithBLOBs(@Param("row") CzNewsDO row, @Param("example") CzNewsExample example);

    int updateByExample(@Param("row") CzNewsDO row, @Param("example") CzNewsExample example);

    int updateByPrimaryKeySelective(CzNewsDO row);

    int updateByPrimaryKeyWithBLOBs(CzNewsDO row);

    int updateByPrimaryKey(CzNewsDO row);
}