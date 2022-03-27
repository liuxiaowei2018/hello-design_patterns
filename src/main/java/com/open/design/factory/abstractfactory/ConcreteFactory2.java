package com.open.design.factory.abstractfactory;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:48
 */
public  class ConcreteFactory2 extends AbstractFactory {
    
    @Override
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB2();
    }
}
