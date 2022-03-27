package com.open.design.prototype;

/**
 * @Description: 使用原型实例指定要创建对象的类型，通过复制这个原型来创建新对象
 * java.lang.Object#clone()
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:54
 */
public abstract class Prototype {
    abstract Prototype myClone();
}

