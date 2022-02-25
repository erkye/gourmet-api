package com.gourmetapi.dao;

import com.gourmetapi.domain.GourmetClassify;
import com.gourmetapi.domain.example.GourmetClassifyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GourmetClassifyMapper {
    int countByExample(GourmetClassifyExample example);

    int deleteByExample(GourmetClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GourmetClassify record);

    int insertSelective(GourmetClassify record);

    List<GourmetClassify> selectByExample(GourmetClassifyExample example);

    GourmetClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GourmetClassify record, @Param("example") GourmetClassifyExample example);

    int updateByExample(@Param("record") GourmetClassify record, @Param("example") GourmetClassifyExample example);

    int updateByPrimaryKeySelective(GourmetClassify record);

    int updateByPrimaryKey(GourmetClassify record);
}