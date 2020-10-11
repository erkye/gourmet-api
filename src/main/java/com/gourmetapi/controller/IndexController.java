package com.gourmetapi.controller;

import com.github.pagehelper.PageInfo;
import com.gourmetapi.domain.GourmetMenu;
import com.gourmetapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-11 - 20:37
 *
 * 处理首页请求的 Controller
 */
@RestController
@RequestMapping("/api/index")
public class IndexController {

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

    /**
     * 分页获取本周佳作的数据
     * @param pageNo 当前页码
     * @param pageSize 每页大小
     * @return
     */
    @GetMapping("/latest")
    public PageInfo getWeekLatestData(@RequestParam(defaultValue = "1")int pageNo,@RequestParam(defaultValue = "10")int pageSize){
        return menuService.getWeekLatestMenu(pageNo, pageSize);
    }
}
