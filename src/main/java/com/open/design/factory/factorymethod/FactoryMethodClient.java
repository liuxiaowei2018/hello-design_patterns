package com.open.design.factory.factorymethod;

/**
 * @Description: 简单工厂测试-范式
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:32
 */
public class FactoryMethodClient {

    public static void main(String[] args) {
        FactoryMethodProduct product01 = new ProductFactory01().factoryMethod();
        FactoryMethodProduct product02 = new ProductFactory02().factoryMethod();
        // do something with the product
    }
}
