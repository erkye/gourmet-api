package com.gourmetapi.service;

import com.github.pagehelper.PageInfo;
import com.gourmetapi.domain.GourmetMaterials;
import com.gourmetapi.domain.GourmetMenu;
import com.gourmetapi.domain.vo.PublishVo;

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

    /**
     * 模糊分页查询菜单信息
     * @param key 查询关键字
     * @param pageNO 查询页码
     * @param pageSize 每页大小
     * @return
     */
    PageInfo getSearchMenu(String key,int pageNO,int pageSize);

    /**
     * 根据id查询菜谱
     * @param id
     * @return
     */
    GourmetMenu getOneById(int id);

    /**
     * 根据菜谱的id查询菜谱用料数据
     * @param menuId
     * @return
     */
    List<GourmetMaterials> getMaterialsByMenuId(int menuId);

    /**
     * 插入菜单
     * @param publishVo
     */
    boolean insertMenu(PublishVo publishVo);
}
