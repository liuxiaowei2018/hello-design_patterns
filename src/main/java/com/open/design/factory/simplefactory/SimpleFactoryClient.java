package com.open.design.factory.simplefactory;

/**
 * @Description: 简单工厂测试-范式
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:32
 */
public class SimpleFactoryClient {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        SimpleFactoryProduct product1 = simpleFactory.createProduct(1);
        SimpleFactoryProduct product2 = simpleFactory.createProduct(2);
        // do something with the product
    }
}
