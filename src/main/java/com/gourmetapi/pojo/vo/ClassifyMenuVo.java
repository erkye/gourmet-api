package com.gourmetapi.pojo.vo;

import com.gourmetapi.pojo.GourmetClassify;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 李发展
 * @date 2020-10-16 - 20:38
 * 二级分类菜单包装类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassifyMenuVo {

    private Integer id;

    private String name;

    private Integer parentId;

    private List<GourmetClassify> childs;

}
