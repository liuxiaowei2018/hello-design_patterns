package com.open.design.observer;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 12:24
 * @Description 主题
 * 定义添加删除关系以及通知订阅者
 */
public interface Subject {

    /**
     * 添加订阅关系
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 移除订阅关系
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知订阅者
     * @param message
     */
    void notifyObservers(String message);


}
