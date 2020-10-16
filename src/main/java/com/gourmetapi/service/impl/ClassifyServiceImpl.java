package com.gourmetapi.service.impl;

import com.gourmetapi.dao.GourmetClassifyMapper;
import com.gourmetapi.domain.GourmetClassify;
import com.gourmetapi.domain.GourmetClassifyExample;
import com.gourmetapi.domain.vo.ClassifyMenuVo;
import com.gourmetapi.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-16 - 20:46
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private GourmetClassifyMapper gourmetClassifyMapper;

    @Override
    public List<ClassifyMenuVo> getClassifyMenu() {
        List<ClassifyMenuVo> result = new ArrayList<>();
        // 查询一级分类
        List<GourmetClassify> firstMenuList = selectByParentId(0);
        for (GourmetClassify classify : firstMenuList) {
            ClassifyMenuVo vo = new ClassifyMenuVo();
            vo.setId(classify.getId());
            vo.setName(classify.getName());
            vo.setParentId(classify.getParentId());
            vo.setChilds(selectByParentId(classify.getId()));
            result.add(vo);
        }
        return result;
    }

    private List<GourmetClassify> selectByParentId(int parentId){
        GourmetClassifyExample example = new GourmetClassifyExample();
        GourmetClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return gourmetClassifyMapper.selectByExample(example);
    }
}
