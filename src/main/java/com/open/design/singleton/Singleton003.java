package com.open.design.singleton;

/**
 * @Description: 饿汉式-线程安全
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:59
 */
public class Singleton003 {

    private Singleton003() {}
    private static Singleton003 instance=new Singleton003();

    public static Singleton003 getInstance() {
        return instance;
    }
}
