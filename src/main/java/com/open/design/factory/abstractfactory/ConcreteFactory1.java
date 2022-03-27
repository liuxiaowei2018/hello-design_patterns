package com.open.design.factory.abstractfactory;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:48
 */
public class ConcreteFactory1 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}


