package com.gourmetapi.controller;

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
 * @date 2020-10-25 - 14:24
 */
@RestController
@RequestMapping("/api/mine")
public class MineController {

    @Autowired
    private MenuService menuService;


    /**
     * 根据用户昵称查找用户收藏的菜谱信息
     * @param nickName
     * @return
     */
    @GetMapping("/star")
    public List<GourmetMenu> getMyStarList(@RequestParam String nickName){
        return menuService.getMyStarMenuList(nickName);
    }

    /**
     * 用户取消收藏
     * @param nickName
     * @param menuId
     * @return
     */
    @GetMapping("/cancelStar")
    public Boolean cancelStar(@RequestParam String nickName,@RequestParam Integer menuId){
        return menuService.deleteStar(nickName, menuId);
    }

    /**
     * 根据用户的昵称查询用户的发布的菜谱列表
     * @param nickName
     * @return
     */
    @GetMapping("/publish")
    public List<GourmetMenu> getMyPublishList(@RequestParam String nickName){
        return menuService.getMyPublishMenuList(nickName);
    }

    /**
     * 根据菜谱的id删除用户的发布的菜谱
     * @param menuId
     * @return
     */
    @GetMapping("/deletePublish")
    public Boolean deleteMyPublishMenuByMenuId(@RequestParam Integer menuId){
        return menuService.deleteMenuById(menuId);
    }
}
