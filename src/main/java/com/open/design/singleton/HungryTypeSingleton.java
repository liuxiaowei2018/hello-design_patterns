package com.open.design.singleton;

/**
 * @Description: 饿汉式-线程安全
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:59
 */
public class HungryTypeSingleton {

    /**
     * 创建一个实例对象
     */
    private static HungryTypeSingleton instance=new HungryTypeSingleton();

    /**
     * 私有构造方法，防止被实例化
     */
    private HungryTypeSingleton() {}

    /**
     * 静态get方法
     */
    public static HungryTypeSingleton getInstance() {
        return instance;
    }
}
