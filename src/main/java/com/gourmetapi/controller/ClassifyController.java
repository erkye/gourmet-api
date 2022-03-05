package com.gourmetapi.controller;

import com.gourmetapi.pojo.vo.ClassifyMenuVo;
import com.gourmetapi.service.ClassifyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 样例控制层
 * @author none
 * @date 2020-10-16 - 20:44
 */
@RestController
@RequestMapping("/api/classify")
@AllArgsConstructor
@Log4j2
public class ClassifyController {

    private final ClassifyService classifyService;

    /**
     * 获取所有的分类数据
     * @return
     */
    @GetMapping("/all")
    public List<ClassifyMenuVo> getAllClassifyData(){
        return classifyService.getClassifyMenu();
    }

}
