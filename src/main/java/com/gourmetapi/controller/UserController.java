package com.gourmetapi.controller;

import com.gourmetapi.pojo.parameters.UserLoginRequest;
import com.gourmetapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户相关的接口
 *
 * @author lfz
 * @since 2022/3/17 10:40 PM
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserLoginRequest request){
        // String password = passwordEncoder.encode(request.getPassword());
        String password = request.getPassword();
        String token = userService.login(request.getOpenCode(), password);
        return token;
    }

}
