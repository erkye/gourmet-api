package com.gourmetapi.pojo.vo;

import com.gourmetapi.pojo.entity.Account;
import com.gourmetapi.pojo.entity.Permission;
import com.gourmetapi.pojo.entity.Role;
import com.gourmetapi.pojo.entity.User;
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
    private User user;

    private Account account;

    private List<Role> roleList;

    private List<Permission> permissionList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionList.stream()
                .map(Permission::getCode)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getOpenCode();
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
        return !account.isDeleted() && !user.isDeleted();
    }
}
