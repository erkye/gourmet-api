package com.gourmetapi.pojo.parameters;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录接口
 *
 * @author lfz
 * @since 2022/3/17 10:46 PM
 */
@Data
public class UserLoginRequest {

    /**
     * 登录账号
     */
    @NotBlank(message = "登录名不能为空")
    private String openCode;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
