package com.gourmetapi.controller;

import com.github.pagehelper.PageInfo;
import com.gourmetapi.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李发展
 * @date 2020-10-16 - 20:41
 */
@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class SearchController {

    private final MenuService menuService;

    @GetMapping("/query")
    public PageInfo searchMenu(String key, @RequestParam(defaultValue = "1")int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        System.out.println(key);
        return menuService.getSearchMenu(key, pageNo, pageSize);
    }
}
