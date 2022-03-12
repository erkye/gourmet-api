package com.gourmetapi.service;

import com.gourmetapi.pojo.vo.UserPermissionVo;

/**
 * 用户Service
 *
 * @author lfz
 * @since 2022/3/12 10:02 AM
 */
public interface UserService {

    /**
     * 根据用户名获取用户权限信息
     * @param userName
     * @return
     */
    UserPermissionVo getByUserName(String userName);

    /**
     * 根据账号和密码生成Token
     * @param openCode
     * @param password
     * @return
     */
    String login(String openCode,String password);
}
