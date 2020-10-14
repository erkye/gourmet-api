package com.gourmetapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gourmetapi.dao.GourmetMenuMapper;
import com.gourmetapi.domain.GourmetMenu;
import com.gourmetapi.domain.GourmetMenuExample;
import com.gourmetapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-9 - 20:30
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private GourmetMenuMapper gourmetMenuMapper;


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
        GourmetMenuExample example = new GourmetMenuExample();
        example.setOrderByClause("id");
        List<GourmetMenu> list = gourmetMenuMapper.selectByExample(example);
        Collections.reverse(list);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo getSearchMenu(String key, int pageNO, int pageSize) {
        PageHelper.startPage(pageNO, pageSize);
        GourmetMenuExample example = new GourmetMenuExample();
        GourmetMenuExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike("%" + key + "%");
        List<GourmetMenu> list = gourmetMenuMapper.selectByExample(example);
        return new PageInfo<>(list);
    }
}
