package com.open.design.strategy.tip002;

import com.open.extension.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:27
 */
@Component
@Slf4j
public class WeChatLoginHandler implements LoginHandler<String> {

    /**
     * 获取登录类型
     *
     * @return
     */
    @Override
    public LoginType getLoginType() {
        return LoginType.WE_CHAT;
    }

    @Override
    public R<?> handleLogin(LoginRequest request) {
        log.info("微信登录：userId：{}", request.getUserId());
        String weChatName = getWeChatName(request);
        return R.success(weChatName,"微信登录成功");
    }

    private String getWeChatName(LoginRequest request) {
        return "wupx";
    }
}
