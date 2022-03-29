package com.open.design.strategy.example.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

/**
 * @Description: 登录策略工厂
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:34
 */
@Component
@Slf4j
public class LoginHandlerFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<LoginType, LoginHandler<Serializable>> LOGIN_HANDLER_MAP = new EnumMap<>(LoginType.class);

    private ApplicationContext appContext;

    public LoginHandler<Serializable> getHandler(LoginType loginType) {
        return LOGIN_HANDLER_MAP.get(loginType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 将Spring容器中所有的LoginHandler注册到LOGIN_HANDLER_MAP
        appContext.getBeansOfType(LoginHandler.class)
                .values()
                .forEach(handler -> LOGIN_HANDLER_MAP.put(handler.getLoginType(), handler));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}
