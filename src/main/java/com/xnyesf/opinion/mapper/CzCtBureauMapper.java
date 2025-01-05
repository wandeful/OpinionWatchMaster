package com.xnyesf.opinion.mapper;

import com.xnyesf.opinion.entity.CzCtBureauDO;
import com.xnyesf.opinion.entity.CzCtBureauExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CzCtBureauMapper {
    long countByExample(CzCtBureauExample example);

    int deleteByExample(CzCtBureauExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CzCtBureauDO row);

    int insertSelective(CzCtBureauDO row);

    List<CzCtBureauDO> selectByExample(CzCtBureauExample example);

    CzCtBureauDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") CzCtBureauDO row, @Param("example") CzCtBureauExample example);

    int updateByExample(@Param("row") CzCtBureauDO row, @Param("example") CzCtBureauExample example);

    int updateByPrimaryKeySelective(CzCtBureauDO row);

    int updateByPrimaryKey(CzCtBureauDO row);
}