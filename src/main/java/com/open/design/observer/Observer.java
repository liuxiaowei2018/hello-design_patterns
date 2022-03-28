package com.open.design.observer;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 12:23
 * @Description 观察者接口
 */
public interface Observer {

    /**
     * 处理业务逻辑
     * @param message
     */
    void handle(String message);
}
