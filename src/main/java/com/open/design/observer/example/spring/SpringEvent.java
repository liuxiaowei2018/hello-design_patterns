package com.open.design.observer.example.spring;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author liuxiaowei
 * @date 2022年04月07日 14:55
 * @Description 观察目标：xxx
 */
@Getter
public class SpringEvent extends ApplicationEvent {

    public SpringEvent(Object source) {
        super(source);
    }
}
