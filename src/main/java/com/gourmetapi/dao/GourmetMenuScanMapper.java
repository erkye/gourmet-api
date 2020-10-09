package com.gourmetapi.dao;

import com.gourmetapi.domain.GourmetMenuScan;
import com.gourmetapi.domain.GourmetMenuScanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GourmetMenuScanMapper {
    int countByExample(GourmetMenuScanExample example);

    int deleteByExample(GourmetMenuScanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GourmetMenuScan record);

    int insertSelective(GourmetMenuScan record);

    List<GourmetMenuScan> selectByExample(GourmetMenuScanExample example);

    GourmetMenuScan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GourmetMenuScan record, @Param("example") GourmetMenuScanExample example);

    int updateByExample(@Param("record") GourmetMenuScan record, @Param("example") GourmetMenuScanExample example);

    int updateByPrimaryKeySelective(GourmetMenuScan record);

    int updateByPrimaryKey(GourmetMenuScan record);
}