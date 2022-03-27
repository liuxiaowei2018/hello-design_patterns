package com.open.design.factory.abstractfactory;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:50
 */
public class AbstractFactoryClient {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
        // do something with productA and productB
    }
}
