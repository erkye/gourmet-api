package com.gourmetapi.controller;

import com.gourmetapi.domain.GourmetMenu;
import com.gourmetapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-9 - 20:29
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 返回首页轮播图的数据
     * @return
     */
    @GetMapping("/recommend")
    public List<GourmetMenu> getRecommendMenu(){
        return menuService.getRecommendMenu();
    }


}
