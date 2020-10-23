package com.gourmetapi.controller;

import com.gourmetapi.domain.GourmetMaterials;
import com.gourmetapi.domain.GourmetMenu;
import com.gourmetapi.domain.vo.PublishVo;
import com.gourmetapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-17 - 19:09
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 根据菜谱的id查询菜谱
     * @param id
     * @return
     */
    @GetMapping("/query")
    public GourmetMenu getMenuById(@RequestParam int id){
        return menuService.getOneById(id);
    }

    /**
     * 根据菜谱id查询菜谱用料数组
     * @param id
     * @return
     */
    @GetMapping("/materials")
    public List<GourmetMaterials> getMaterialsByMenuId(@RequestParam int id){
        return menuService.getMaterialsByMenuId(id);
    }

    /**
     * 发布菜谱
     * @param publishVo
     * @return
     */
    @PostMapping("/publish")
    public String publishMenu(@RequestBody PublishVo publishVo){
        return menuService.insertMenu(publishVo)?"ok":"fail";
    }
}
