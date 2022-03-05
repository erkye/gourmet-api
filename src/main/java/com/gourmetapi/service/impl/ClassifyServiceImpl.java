package com.gourmetapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gourmetapi.dao.GourmetClassifyMapper;
import com.gourmetapi.pojo.GourmetClassify;
import com.gourmetapi.pojo.vo.ClassifyMenuVo;
import com.gourmetapi.service.ClassifyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-16 - 20:46
 */
@Service
@AllArgsConstructor
public class ClassifyServiceImpl implements ClassifyService {

    private final GourmetClassifyMapper gourmetClassifyMapper;

    @Override
    public List<ClassifyMenuVo> getClassifyMenu() {
        List<ClassifyMenuVo> result = new ArrayList<>();
        // 查询一级分类
        List<GourmetClassify> firstMenuList = selectByParentId(0);
        firstMenuList.forEach(gourmetClassify -> {
            ClassifyMenuVo vo = ClassifyMenuVo.builder()
                    .id(gourmetClassify.getId())
                    .name(gourmetClassify.getName())
                    .parentId(gourmetClassify.getParentId())
                    .childs(selectByParentId(gourmetClassify.getId()))
                    .build();
            result.add(vo);
        });
        return result;
    }

    private List<GourmetClassify> selectByParentId(int parentId){
        LambdaQueryWrapper<GourmetClassify> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(GourmetClassify::getParentId,parentId);
        return gourmetClassifyMapper.selectList(lambdaQuery);
    }
}
