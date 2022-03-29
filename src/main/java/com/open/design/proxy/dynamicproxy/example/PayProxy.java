package com.open.design.proxy.dynamicproxy.example;

import java.lang.reflect.Proxy;

public class PayProxy {

    private Object target;

    public PayProxy(Object target) {
        this.target = target;
    }

    public Object getPayProxy() {
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("start...");

            Object result = method.invoke(target, args);

            System.out.println("stop");
            return result;
        });
        return proxyInstance;
    }

}
