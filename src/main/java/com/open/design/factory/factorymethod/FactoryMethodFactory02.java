package com.open.design.factory.factorymethod;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:43
 */
public class FactoryMethodFactory02 extends FactoryMethodFactory{

    @Override
    public FactoryMethodProduct factoryMethod() {
        return new FactoryMethodProduct02();
    }
}
