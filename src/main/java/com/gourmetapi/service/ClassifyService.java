package com.gourmetapi.service;

import com.gourmetapi.domain.vo.ClassifyMenuVo;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-16 - 20:45
 */
public interface ClassifyService {

    /**
     * 获取两级分类的数据
     * @return
     */
    List<ClassifyMenuVo> getClassifyMenu();
}
