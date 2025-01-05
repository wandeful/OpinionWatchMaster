package com.xnyesf.opinion.mapper;

import com.xnyesf.opinion.entity.CzGovDO;
import com.xnyesf.opinion.entity.CzGovExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CzGovMapper {
    long countByExample(CzGovExample example);

    int deleteByExample(CzGovExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CzGovDO row);

    int insertSelective(CzGovDO row);

    List<CzGovDO> selectByExampleWithBLOBs(CzGovExample example);

    List<CzGovDO> selectByExample(CzGovExample example);

    CzGovDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") CzGovDO row, @Param("example") CzGovExample example);

    int updateByExampleWithBLOBs(@Param("row") CzGovDO row, @Param("example") CzGovExample example);

    int updateByExample(@Param("row") CzGovDO row, @Param("example") CzGovExample example);

    int updateByPrimaryKeySelective(CzGovDO row);

    int updateByPrimaryKeyWithBLOBs(CzGovDO row);

    int updateByPrimaryKey(CzGovDO row);
}