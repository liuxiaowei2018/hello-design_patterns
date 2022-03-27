package com.open.design.prototype;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:55
 */
public class PrototypeClient {

    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("abc");
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}
