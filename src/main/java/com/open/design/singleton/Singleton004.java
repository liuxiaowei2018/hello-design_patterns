package com.open.design.singleton;

/**
 * @Description: 双重校验锁-线程安全
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:01
 */
public class Singleton004 {

    private Singleton004() {
    }

    /**
     * volatile关键字:
     * 为 uniqueInstance 分配内存空间
     * 初始化 uniqueInstance
     * 将 uniqueInstance 指向分配的内存地址
     * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
     */
    private volatile static Singleton004 instance = null;

    public static Singleton004 getInstance() {
        if (instance == null) {
            synchronized (Singleton004.class) {
                if (instance == null) {
                    instance = new Singleton004();
                }
            }
        }
        return instance;
    }

}
