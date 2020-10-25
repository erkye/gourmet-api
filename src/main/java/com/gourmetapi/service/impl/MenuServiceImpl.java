package com.gourmetapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gourmetapi.dao.*;
import com.gourmetapi.domain.*;
import com.gourmetapi.domain.vo.PublishVo;
import com.gourmetapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private GourmetStarMapper gourmetStarMapper;


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

    @Override
    public List<GourmetMenu> getMyStarMenuList(String nickName) {
        List<GourmetMenu> result = new ArrayList<>();
        // 查找收藏表中的数据
        GourmetStarExample starExample = new GourmetStarExample();
        GourmetStarExample.Criteria starExampleCriteria = starExample.createCriteria();
        starExampleCriteria.andNickNameEqualTo(nickName.trim());
        List<GourmetStarKey> keyList = gourmetStarMapper.selectByExample(starExample);

        for (GourmetStarKey starKey : keyList) {
            GourmetMenu menu = gourmetMenuMapper.selectByPrimaryKey(starKey.getMenuId());
            // 查找浏览量和收藏数据
            GourmetMenuScanExample scanExample = new GourmetMenuScanExample();
            GourmetMenuScanExample.Criteria scanExampleCriteria = scanExample.createCriteria();
            scanExampleCriteria.andMenuIdEqualTo(starKey.getMenuId());
            List<GourmetMenuScan> scans = gourmetMenuScanMapper.selectByExample(scanExample);
            menu.setPageviews(scans.get(0).getPageviews());
            menu.setFavorites(scans.get(0).getFavorites());
            result.add(menu);
        }


        return result;
    }

    @Override
    public boolean deleteStar(String nickName, Integer menuId) {
        GourmetStarExample example = new GourmetStarExample();
        GourmetStarExample.Criteria criteria = example.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        criteria.andMenuIdEqualTo(menuId);
        int i = gourmetStarMapper.deleteByExample(example);
        // 收藏数-1
        GourmetMenuScanExample scanExample = new GourmetMenuScanExample();
        GourmetMenuScanExample.Criteria scanExampleCriteria = scanExample.createCriteria();
        scanExampleCriteria.andMenuIdEqualTo(menuId);
        List<GourmetMenuScan> scans = gourmetMenuScanMapper.selectByExample(scanExample);
        if(scans.size()>0){
            GourmetMenuScan scan = scans.get(0);
            scan.setFavorites(scan.getFavorites()-1);
            gourmetMenuScanMapper.updateByPrimaryKey(scan);
        }
        return i>0;
    }

    @Override
    public boolean insertStarMenu(String nickName, Integer menuId) {

        GourmetStarKey starKey = new GourmetStarKey();
        starKey.setNickName(nickName);
        starKey.setMenuId(menuId);
        int i = gourmetStarMapper.insert(starKey);
        if(i>0){
            GourmetMenuScanExample scanExample = new GourmetMenuScanExample();
            GourmetMenuScanExample.Criteria criteria = scanExample.createCriteria();
            criteria.andMenuIdEqualTo(menuId);
            List<GourmetMenuScan> scans = gourmetMenuScanMapper.selectByExample(scanExample);
            if(scans.size()>0){
                GourmetMenuScan scan = scans.get(0);
                scan.setFavorites(scan.getFavorites()+1);
                int i1 = gourmetMenuScanMapper.updateByPrimaryKey(scan);
                return i1 > 0;
            }
        }
        return false;
    }
}
