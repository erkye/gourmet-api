package com.gourmetapi.controller;

import com.gourmetapi.domain.vo.ClassifyMenuVo;
import com.gourmetapi.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-16 - 20:44
 */
@RestController
@RequestMapping("/api/classify")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;

    /**
     * 获取所有的分类数据
     * @return
     */
    @GetMapping("/all")
    public List<ClassifyMenuVo> getAllClassifyData(){
        return classifyService.getClassifyMenu();
    }

}
