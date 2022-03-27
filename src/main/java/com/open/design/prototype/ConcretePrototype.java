package com.open.design.prototype;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:54
 */
public class ConcretePrototype extends Prototype {

    private String filed;

    public ConcretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}


