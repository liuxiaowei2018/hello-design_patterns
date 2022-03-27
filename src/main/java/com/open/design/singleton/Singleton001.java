package com.open.design.singleton;

/**
 * @Description: 单例-枚举实现1
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:42
 */
public class Singleton001 {

    private Singleton001() {
    }

    public static enum SingletonEnum {
        SINGLETON001;
        private Singleton001 instance = null;

        private SingletonEnum() {
            instance = new Singleton001();
        }

        public Singleton001 getInstance() {
            return instance;
        }
    }
}
