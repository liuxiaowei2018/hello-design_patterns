package com.open.design.singleton;

/**
 * @Description: 单例-枚举实现[模板]
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:07
 */
public enum SingletonEnum {

    INSTANCE;

    public static void main(String[] args) {

        // 单例测试
        SingletonEnum firstSingleton = SingletonEnum.INSTANCE;

        System.out.println(firstSingleton);
        SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
        System.out.println(secondSingleton);

        // 反射获取实例测试
        try {
            SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
            for (SingletonEnum enumConstant : enumConstants) {
                System.out.println(enumConstant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
