package com.gourmetapi.service;

import com.gourmetapi.domain.GourmetMenu;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-9 - 20:29
 */
public interface MenuService {

    /**
     * 获取被推荐到首页滚动显示的菜谱数据
     * @return
     */
    List<GourmetMenu> getRecommendMenu();
}
