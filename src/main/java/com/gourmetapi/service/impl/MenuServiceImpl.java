package com.gourmetapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gourmetapi.dao.GourmetMaterialsMapper;
import com.gourmetapi.dao.GourmetMenuMapper;
import com.gourmetapi.dao.GourmetMenuScanMapper;
import com.gourmetapi.domain.*;
import com.gourmetapi.domain.vo.PublishVo;
import com.gourmetapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-9 - 20:30
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private GourmetMenuMapper gourmetMenuMapper;

    @Autowired
    private GourmetMenuScanMapper gourmetMenuScanMapper;

    @Autowired
    private GourmetMaterialsMapper gourmetMaterialsMapper;


    @Override
    public List<GourmetMenu> getRecommendMenu() {
        GourmetMenuExample example = new GourmetMenuExample();
        GourmetMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRecommendEqualTo(true);
        return gourmetMenuMapper.selectByExample(example);
    }

    @Override
    public PageInfo getWeekLatestMenu(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<GourmetMenu> list = gourmetMenuMapper.selectWeekLatest();
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo getSearchMenu(String key, int pageNO, int pageSize) {
        PageHelper.startPage(pageNO, pageSize);
        List<GourmetMenu> list = gourmetMenuMapper.selectByTitleLikeKey("%" + key + "%");
        return new PageInfo<>(list);
    }

    @Override
    public GourmetMenu getOneById(int id) {
        // 获取一次浏览量+1
        GourmetMenuScanExample example = new GourmetMenuScanExample();
        GourmetMenuScanExample.Criteria criteria = example.createCriteria();
        criteria.andMenuIdEqualTo(id);
        List<GourmetMenuScan> gourmetMenuScansList = gourmetMenuScanMapper.selectByExample(example);
        if(gourmetMenuScansList != null && gourmetMenuScansList.size()>0){
            // 修改第一项
            GourmetMenuScan menuScan = gourmetMenuScansList.get(0);
            menuScan.setPageviews(menuScan.getPageviews()+1);
            gourmetMenuScanMapper.updateByPrimaryKey(menuScan);
        }
        GourmetMenuExample menuExample = new GourmetMenuExample();
        GourmetMenuExample.Criteria menuExampleCriteria = menuExample.createCriteria();
        menuExampleCriteria.andIdEqualTo(id);
        GourmetMenu gourmetMenu = gourmetMenuMapper.selectByExampleWithBLOBs(menuExample).get(0);
        if(gourmetMenu!=null){
            GourmetMenuScanExample scanExample = new GourmetMenuScanExample();
            GourmetMenuScanExample.Criteria criteria1 = scanExample.createCriteria();
            criteria1.andMenuIdEqualTo(gourmetMenu.getId());
            GourmetMenuScan gourmetMenuScan = gourmetMenuScanMapper.selectByExample(scanExample).get(0);
            if(gourmetMenuScan!=null){
                gourmetMenu.setFavorites(gourmetMenuScan.getFavorites());
                gourmetMenu.setPageviews(gourmetMenuScan.getPageviews());
            }
        }
        return gourmetMenu;
    }

    @Override
    public List<GourmetMaterials> getMaterialsByMenuId(int menuId) {
        GourmetMaterialsExample example = new GourmetMaterialsExample();
        GourmetMaterialsExample.Criteria criteria = example.createCriteria();
        criteria.andMenuIdEqualTo(menuId);
        return gourmetMaterialsMapper.selectByExample(example);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertMenu(PublishVo publishVo) {
        GourmetMenu menu = publishVo.getGourmetMenu();
        int i1 = gourmetMenuMapper.insert(menu);
        List<GourmetMaterials> materials = publishVo.getMaterials();
        int i2 = 0;
        for (GourmetMaterials material : materials) {
            material.setMenuId(menu.getId());
            i2+=gourmetMaterialsMapper.insert(material);
        }
        GourmetMenuScan gourmetMenuScan = new GourmetMenuScan();
        gourmetMenuScan.setPageviews(0L);
        gourmetMenuScan.setFavorites(0L);
        gourmetMenuScan.setMenuId(menu.getId());

        int i3 = gourmetMenuScanMapper.insert(gourmetMenuScan);

        return i1 + i2 + i3 == publishVo.getMaterials().size() + 2;

    }
}
