package com.open.design.singleton;

/**
 * @Description: 双重校验锁-线程安全
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:01
 */
public class DoubleLockSingleton {

    /**
     * volatile关键字:
     * 为 instance 分配内存空间
     * 初始化 instance
     * 将 instance 指向分配的内存地址
     * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
     */
    private volatile static DoubleLockSingleton instance = null;

    private DoubleLockSingleton() {}


    public static DoubleLockSingleton getInstance() {
        // 先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            // 同步块，线程安全的创建实例
            synchronized (DoubleLockSingleton.class) {
                // 再次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }
}
