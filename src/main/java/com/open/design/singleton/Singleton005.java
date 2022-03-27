package com.open.design.singleton;

/**
 * @Description: 静态内部类实现
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:05
 */
public class Singleton005 {

    private Singleton005() {
    }

    /**
     * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载进内存
     * 此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
     */
    private static class SingletonHolder {
        private static final Singleton005 INSTANCE = new Singleton005();
    }

    public static Singleton005 getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}

