package com.gourmetapi.dao;

import com.gourmetapi.domain.GourmetMaterials;
import com.gourmetapi.domain.example.GourmetMaterialsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GourmetMaterialsMapper {
    int countByExample(GourmetMaterialsExample example);

    int deleteByExample(GourmetMaterialsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GourmetMaterials record);

    int insertSelective(GourmetMaterials record);

    List<GourmetMaterials> selectByExample(GourmetMaterialsExample example);

    GourmetMaterials selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GourmetMaterials record, @Param("example") GourmetMaterialsExample example);

    int updateByExample(@Param("record") GourmetMaterials record, @Param("example") GourmetMaterialsExample example);

    int updateByPrimaryKeySelective(GourmetMaterials record);

    int updateByPrimaryKey(GourmetMaterials record);
}