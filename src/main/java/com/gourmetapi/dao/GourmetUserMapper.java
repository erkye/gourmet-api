package com.gourmetapi.dao;

import com.gourmetapi.domain.GourmetUser;
import com.gourmetapi.domain.GourmetUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GourmetUserMapper {
    int countByExample(GourmetUserExample example);

    int deleteByExample(GourmetUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GourmetUser record);

    int insertSelective(GourmetUser record);

    List<GourmetUser> selectByExample(GourmetUserExample example);

    GourmetUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GourmetUser record, @Param("example") GourmetUserExample example);

    int updateByExample(@Param("record") GourmetUser record, @Param("example") GourmetUserExample example);

    int updateByPrimaryKeySelective(GourmetUser record);

    int updateByPrimaryKey(GourmetUser record);
}