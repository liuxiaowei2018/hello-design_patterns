package com.open.design.factory.factorymethod;

/**
 * @Description: 定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化操作推迟到子类。
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:40
 */
public abstract class FactoryMethodFactory {
    abstract public FactoryMethodProduct factoryMethod();
    public void doSomething() {
        FactoryMethodProduct product = factoryMethod();
        // do something with the product
    }
}

