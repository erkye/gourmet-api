package com.gourmetapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gourmetapi.dao.GourmetClassifyMapper;
import com.gourmetapi.domain.GourmetClassify;
import com.gourmetapi.domain.vo.ClassifyMenuVo;
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
            ClassifyMenuVo vo = new ClassifyMenuVo();
            vo.setId(gourmetClassify.getId());
            vo.setName(gourmetClassify.getName());
            vo.setParentId(gourmetClassify.getParentId());
            vo.setChilds(selectByParentId(gourmetClassify.getId()));
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
