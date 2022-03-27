package com.open.design.singleton;

/**
 * @Description: 懒汉式-线程不安全
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:57
 */
public class LazyTypeSingleton {

    private static LazyTypeSingleton instance;

    private LazyTypeSingleton() {
    }

    public static LazyTypeSingleton getInstance() {
        if (instance == null) {
            instance = new LazyTypeSingleton();
        }
        return instance;
    }
}

