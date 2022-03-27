package com.open.design.singleton;

/**
 * @Description: 懒汉式-线程不安全
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:57
 */
public class Singleton002 {

    private static Singleton002 instance;

    private Singleton002() {
    }

    public static Singleton002 getUniqueInstance() {
        if (instance == null) {
            instance = new Singleton002();
        }
        return instance;
    }
}

