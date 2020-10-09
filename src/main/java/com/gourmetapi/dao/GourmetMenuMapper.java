package com.gourmetapi.dao;

import com.gourmetapi.domain.GourmetMenu;
import com.gourmetapi.domain.GourmetMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GourmetMenuMapper {
    int countByExample(GourmetMenuExample example);

    int deleteByExample(GourmetMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GourmetMenu record);

    int insertSelective(GourmetMenu record);

    List<GourmetMenu> selectByExampleWithBLOBs(GourmetMenuExample example);

    List<GourmetMenu> selectByExample(GourmetMenuExample example);

    GourmetMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GourmetMenu record, @Param("example") GourmetMenuExample example);

    int updateByExampleWithBLOBs(@Param("record") GourmetMenu record, @Param("example") GourmetMenuExample example);

    int updateByExample(@Param("record") GourmetMenu record, @Param("example") GourmetMenuExample example);

    int updateByPrimaryKeySelective(GourmetMenu record);

    int updateByPrimaryKeyWithBLOBs(GourmetMenu record);

    int updateByPrimaryKey(GourmetMenu record);
}