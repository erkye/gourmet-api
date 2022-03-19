package com.gourmetapi.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gourmetapi.dao.*;
import com.gourmetapi.pojo.entity.*;
import com.gourmetapi.pojo.vo.MyUserDetails;
import com.gourmetapi.service.UserService;
import com.gourmetapi.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户相关service实现类
 *
 * @author lfz
 * @since 2022/3/12 10:04 AM
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final AccountMapper accountMapper;

    private final UserMapper userMapper;

    private final UserRoleMapper userRoleMapper;

    private final RoleMapper roleMapper;

    private final RolePermissionMapper rolePermissionMapper;

    private final PermissionMapper permissionMapper;


    @Override
    public UserDetails getByOpenCode(String openCode) {

        Optional<Account> accountOptional = Optional.ofNullable(accountMapper.selectOne(Wrappers.lambdaQuery(Account.class)
                .eq(Account::getOpenCode, openCode)));
        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            List<Role> roleList = new ArrayList<>();
            List<Permission> permissionList = new ArrayList<>();
            // 查询用户
            Optional<User> userOptional = Optional.ofNullable(userMapper.selectById(account.getUserId()));
            if(userOptional.isPresent()){
                User user = userOptional.get();
                // 查询角色
                List<UserRole> userRoleList = userRoleMapper.selectList(
                        Wrappers.<UserRole>lambdaQuery()
                                .eq(UserRole::getUserId, user.getId())
                );
                if(CollectionUtil.isNotEmpty(userRoleList)){
                    List<Long> roleIdQueryList = userRoleList.stream()
                            .map(UserRole::getRoleId)
                            .collect(Collectors.toList());
                    roleList = roleMapper.selectBatchIds(roleIdQueryList);
                    // 查询权限
                    List<Long> roleIdList = roleList.stream()
                            .map(Role::getId)
                            .collect(Collectors.toList());
                    if(CollectionUtil.isNotEmpty(roleIdList)){
                        List<RolePermission> rolePermissionList = rolePermissionMapper.selectBatchIds(roleIdList);
                        List<Long> permissionIdList = rolePermissionList.stream()
                                .map(RolePermission::getPermissionId)
                                .collect(Collectors.toList());
                        permissionList = permissionMapper.selectBatchIds(permissionIdList);
                    }
                }

                return MyUserDetails.builder()
                        .account(account)
                        .user(user)
                        .roleList(roleList)
                        .permissionList(permissionList)
                        .build();
            }
        }


        return null;
    }

    @Override
    public String login(String openCode, String password) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class)
                .eq(Account::getOpenCode, openCode));
        if(account != null){
            User user = userMapper.selectById(account.getUserId());
            if(StringUtils.equals(password,user.getPassword())){
                return JwtUtil.createJwtToken(openCode);
            }
        }
        return null;
    }
}
