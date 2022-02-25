package com.gourmetapi.dao;

import com.gourmetapi.domain.example.GourmetStarExample;
import com.gourmetapi.domain.GourmetStarKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GourmetStarMapper {
    int countByExample(GourmetStarExample example);

    int deleteByExample(GourmetStarExample example);

    int deleteByPrimaryKey(GourmetStarKey key);

    int insert(GourmetStarKey record);

    int insertSelective(GourmetStarKey record);

    List<GourmetStarKey> selectByExample(GourmetStarExample example);

    int updateByExampleSelective(@Param("record") GourmetStarKey record, @Param("example") GourmetStarExample example);

    int updateByExample(@Param("record") GourmetStarKey record, @Param("example") GourmetStarExample example);
}