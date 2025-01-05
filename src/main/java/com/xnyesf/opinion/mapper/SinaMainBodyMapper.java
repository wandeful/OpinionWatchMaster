package com.xnyesf.opinion.mapper;

import com.xnyesf.opinion.entity.SinaMainBodyDO;
import com.xnyesf.opinion.entity.SinaMainBodyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SinaMainBodyMapper {
    long countByExample(SinaMainBodyExample example);

    int deleteByExample(SinaMainBodyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SinaMainBodyDO row);

    int insertSelective(SinaMainBodyDO row);

    List<SinaMainBodyDO> selectByExampleWithBLOBs(SinaMainBodyExample example);

    List<SinaMainBodyDO> selectByExample(SinaMainBodyExample example);

    SinaMainBodyDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") SinaMainBodyDO row, @Param("example") SinaMainBodyExample example);

    int updateByExampleWithBLOBs(@Param("row") SinaMainBodyDO row, @Param("example") SinaMainBodyExample example);

    int updateByExample(@Param("row") SinaMainBodyDO row, @Param("example") SinaMainBodyExample example);

    int updateByPrimaryKeySelective(SinaMainBodyDO row);

    int updateByPrimaryKeyWithBLOBs(SinaMainBodyDO row);

    int updateByPrimaryKey(SinaMainBodyDO row);
}