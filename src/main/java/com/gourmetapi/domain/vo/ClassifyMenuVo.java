package com.gourmetapi.domain.vo;

import com.gourmetapi.domain.GourmetClassify;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-16 - 20:38
 * 二级分类菜单包装类
 */
public class ClassifyMenuVo {

    private Integer id;

    private String name;

    private Integer parentId;

    private List<GourmetClassify> childs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<GourmetClassify> getChilds() {
        return childs;
    }

    public void setChilds(List<GourmetClassify> childs) {
        this.childs = childs;
    }
}
