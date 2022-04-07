package com.open.design.observer.example.jdk;

import lombok.Getter;

import java.util.Observable;

/**
 * @author liuxiaowei
 * @date 2022年04月07日 14:34
 * @Description 观察目标:文章发布者
 */
@Getter
public class JdkObservable extends Observable{

    private String article;

    public void publish(String article) {
        // 发表文章
        this.article = article;
        // 改变状态
        this.setChanged();
        // 通知所有观察者
        this.notifyObservers();
    }

    /*{
        // 源码解析：
        // 先获取同步锁，判断状态是否更新，如已更新则清空观察目标状态
        // 然后再使用 for 循环遍历所有观察者，一一调用观察者的更新方法通知观察者更新。
        notifyObservers();

    }*/
}
