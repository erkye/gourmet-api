package com.gourmetapi.model.vo;

import com.gourmetapi.model.entity.AccountEntity;
import com.gourmetapi.model.entity.PermissionEntity;
import com.gourmetapi.model.entity.RoleEntity;
import com.gourmetapi.model.entity.UserEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义用户权限包装类
 *
 * @author lfz
 * @since 2022/3/12 9:52 AM
 */
@Data
@Builder
public class MyUserDetails implements Serializable, UserDetails {

    private static final long serialVersionUID = 2538295935813906794L;
    private UserEntity userEntity;

    private AccountEntity accountEntity;

    private List<RoleEntity> roleEntityList;

    private List<PermissionEntity> permissionEntityList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionEntityList.stream()
                .map(PermissionEntity::getCode)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return accountEntity.getOpenCode();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !accountEntity.isDeleted() && !userEntity.isDeleted();
    }
}
