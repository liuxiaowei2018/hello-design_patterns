package com.open.design.observer.example.jdk;

/**
 * @author liuxiaowei
 * @date 2022年04月07日 14:48
 * @Description
 */
public class ObserverTest {

    public static void main(String[] args) {
        // 创建一个观察目标
        JdkObservable jdkObservable = new JdkObservable();

        // 添加观察者
        jdkObservable.addObserver(new ReaderObserver("小明"));
        jdkObservable.addObserver(new ReaderObserver("小张"));
        jdkObservable.addObserver(new ReaderObserver("小爱"));

        // 发表文章
        jdkObservable.publish("什么是观察者模式？");
    }
}
