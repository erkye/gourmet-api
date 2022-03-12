package com.gourmetapi.pojo.vo;

import com.gourmetapi.pojo.entity.Permission;
import com.gourmetapi.pojo.entity.Role;
import com.gourmetapi.pojo.entity.User;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户权限包装类
 *
 * @author lfz
 * @since 2022/3/12 9:52 AM
 */
@Data
@Builder
public class UserPermissionVo implements Serializable {

    private static final long serialVersionUID = 2538295935813906794L;
    private User user;

    private List<Role> roleList;

    private List<Permission> permissionList;
}
