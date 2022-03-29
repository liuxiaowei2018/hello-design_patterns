package com.open.design.strategy.example.login;

import com.open.extension.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:31
 */
@Component
@Slf4j
public class QQLoginHandler implements LoginHandler<Serializable> {

    @Override
    public LoginType getLoginType() {
        return LoginType.QQ;
    }

    @Override
    public R<?> handleLogin(LoginRequest request) {
        return R.success(null,"QQ登录成功");
    }
}
