package com.open.design.strategy.example.login;

import com.open.extension.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 登录接口
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:39
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public R<?> login(@RequestParam LoginType loginType, @RequestParam Long userId) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginType(loginType);
        loginRequest.setUserId(userId);
        return loginService.login(loginRequest);
    }
}
