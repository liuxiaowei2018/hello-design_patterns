package com.open.design.observer;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 12:28
 * @Description 具体的观察者类，实现观察者接口的handle方法，处理本身的业务逻辑
 */
public class ObserverOne implements Observer{

    @Override
    public void handle(String message) {
        // 模拟处理业务逻辑
        System.out.println("ObserverOne 处理业务::" + message);
    }
}
