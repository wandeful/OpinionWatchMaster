package com.xnyesf.opinion.mapper;

import com.xnyesf.opinion.entity.SinaCommentsDO;
import com.xnyesf.opinion.entity.SinaCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SinaCommentsMapper {
    long countByExample(SinaCommentsExample example);

    int deleteByExample(SinaCommentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SinaCommentsDO row);

    int insertSelective(SinaCommentsDO row);

    List<SinaCommentsDO> selectByExample(SinaCommentsExample example);

    SinaCommentsDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") SinaCommentsDO row, @Param("example") SinaCommentsExample example);

    int updateByExample(@Param("row") SinaCommentsDO row, @Param("example") SinaCommentsExample example);

    int updateByPrimaryKeySelective(SinaCommentsDO row);

    int updateByPrimaryKey(SinaCommentsDO row);
}