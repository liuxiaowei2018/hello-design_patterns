package com.open.design.factory.factorymethod.example;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 0:43
 * @Description
 */
public enum ShareTypeEnum {

    SUCCESS_ORDER("successOrder");

    private String name;

    ShareTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
