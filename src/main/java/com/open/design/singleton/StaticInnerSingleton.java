package com.open.design.singleton;

/**
 * @Description: 静态内部类实现
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:05
 */
public class StaticInnerSingleton {

    /**
     * 私有构造方法，防止被实例化
     */
    private StaticInnerSingleton() {
    }

    /**
     * 此处使用一个内部类来维护单例
     * 只有当调用 getInstance() 方法从而触发 SingletonFactory.INSTANCE 时 SingletonFactory 才会被加载进内存
     * 此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
     */
    private static class SingletonFactory {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return SingletonFactory.INSTANCE;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return getInstance();
    }
}

