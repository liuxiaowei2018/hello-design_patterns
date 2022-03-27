package com.open.design.strategy.tip002;

import com.open.extension.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:36
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginHandlerFactory loginHandlerFactory;

    @Override
    public R<?> login(LoginRequest request) {
        LoginType loginType = request.getLoginType();
        //根据loginType找到对应的登录处理器
        LoginHandler<Serializable> loginHandler = loginHandlerFactory.getHandler(loginType);
        //处理登录
        return loginHandler.handleLogin(request);
    }
}
