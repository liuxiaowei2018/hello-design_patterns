package com.open.design.strategy.tip002;

import com.open.extension.R;

import java.io.Serializable;

public interface LoginHandler<T extends Serializable> {

    //登录策略接口
    //1.获取策略类型的方法
    //2.处理策略逻辑的方法

    LoginType getLoginType();

    R<?> handleLogin(LoginRequest request);

}
