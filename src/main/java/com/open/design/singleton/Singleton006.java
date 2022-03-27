package com.open.design.singleton;

/**
 * @Description: 单例-枚举实现[模板]
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:07
 */
public enum Singleton006 {

    INSTANCE;
    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {

        // 单例测试
        Singleton006 firstSingleton = Singleton006.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());
        Singleton006 secondSingleton = Singleton006.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());

        // 反射获取实例测试
        try {
            Singleton006[] enumConstants = Singleton006.class.getEnumConstants();
            for (Singleton006 enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
