package com.open.design.strategy.tip002;

import com.open.extension.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.Serializable;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:32
 */
@Component
@Slf4j
public class WeiBoLoginHandler implements LoginHandler<Serializable> {

    @Override
    public LoginType getLoginType() {
        return LoginType.WEI_BO;
    }

    @Override
    public R<?> handleLogin(LoginRequest request) {
        log.info("微博登录：userId：{}", request.getUserId());
        return R.success(null,"微博登录成功");
    }
}
