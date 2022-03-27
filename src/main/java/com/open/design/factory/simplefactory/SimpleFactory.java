package com.open.design.factory.simplefactory;

/**
 * @Description: 简单工厂-范式
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:35
 */
public class SimpleFactory {

    public SimpleFactoryProduct createProduct(int type) {
        if (type == 1) {
            return new SimpleFactoryProduct01();
        } else if (type == 2) {
            return new SimpleFactoryProduct02();
        }
        return null;
    }
}
