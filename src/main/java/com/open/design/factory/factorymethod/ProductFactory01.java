package com.open.design.factory.factorymethod;

/**
 * @Description: 创建工厂01
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:43
 */
public class ProductFactory01 extends FactoryMethod {

    @Override
    public FactoryMethodProduct factoryMethod() {
        return new FactoryMethodProduct01();
    }
}
