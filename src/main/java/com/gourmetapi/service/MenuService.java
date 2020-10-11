package com.gourmetapi.service;

import com.github.pagehelper.PageInfo;
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

    /**
     * 分页获取最新的菜谱表数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo getWeekLatestMenu(int pageNo,int pageSize);
}
