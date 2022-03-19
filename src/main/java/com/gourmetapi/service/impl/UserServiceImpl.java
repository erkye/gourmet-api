package com.gourmetapi.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gourmetapi.dao.*;
import com.gourmetapi.model.entity.*;
import com.gourmetapi.model.vo.MyUserDetails;
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

        Optional<AccountEntity> accountOptional = Optional.ofNullable(accountMapper.selectOne(Wrappers.lambdaQuery(AccountEntity.class)
                .eq(AccountEntity::getOpenCode, openCode)));
        if(accountOptional.isPresent()){
            AccountEntity accountEntity = accountOptional.get();
            List<RoleEntity> roleEntityList = new ArrayList<>();
            List<PermissionEntity> permissionEntityList = new ArrayList<>();
            // 查询用户
            Optional<UserEntity> userOptional = Optional.ofNullable(userMapper.selectById(accountEntity.getUserId()));
            if(userOptional.isPresent()){
                UserEntity user = userOptional.get();
                // 查询角色
                List<UserRole> userRoleList = userRoleMapper.selectList(
                        Wrappers.<UserRole>lambdaQuery()
                                .eq(UserRole::getUserId, user.getId())
                );
                if(CollectionUtil.isNotEmpty(userRoleList)){
                    List<Long> roleIdQueryList = userRoleList.stream()
                            .map(UserRole::getRoleId)
                            .collect(Collectors.toList());
                    roleEntityList = roleMapper.selectBatchIds(roleIdQueryList);
                    // 查询权限
                    List<Long> roleIdList = roleEntityList.stream()
                            .map(RoleEntity::getId)
                            .collect(Collectors.toList());
                    if(CollectionUtil.isNotEmpty(roleIdList)){
                        List<RolePermissionEntity> rolePermissionEntityList = rolePermissionMapper.selectBatchIds(roleIdList);
                        List<Long> permissionIdList = rolePermissionEntityList.stream()
                                .map(RolePermissionEntity::getPermissionId)
                                .collect(Collectors.toList());
                        permissionEntityList = permissionMapper.selectBatchIds(permissionIdList);
                    }
                }

                return MyUserDetails.builder()
                        .accountEntity(accountEntity)
                        .userEntity(user)
                        .roleEntityList(roleEntityList)
                        .permissionEntityList(permissionEntityList)
                        .build();
            }
        }


        return null;
    }

    @Override
    public String login(String openCode, String password) {
        AccountEntity accountEntity = accountMapper.selectOne(Wrappers.lambdaQuery(AccountEntity.class)
                .eq(AccountEntity::getOpenCode, openCode));
        if(accountEntity != null){
            UserEntity user = userMapper.selectById(accountEntity.getUserId());
            if(StringUtils.equals(password,user.getPassword())){
                return JwtUtil.createJwtToken(openCode);
            }
        }
        return null;
    }
}
