package com.open.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 12:26
 * @Description 创建的具体主题，并且构建一个容器来维护订阅关系，支持添加删除关系，以及通知订阅者
 */
public class ConcreteSubject implements Subject{

    /**
     * 订阅者容器
     */
    private List<Observer> observers = new ArrayList<>();


    @Override
    public void attach(Observer observer) {
        // 添加订阅关系
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        // 移除订阅关系
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        // 通知订阅者们
        for (Observer observer : observers) {
            observer.handle(message);
        }
    }
}
