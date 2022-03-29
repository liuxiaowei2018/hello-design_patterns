package com.open.design.proxy.dynamicproxy.example;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {

        PayProxy proxy = new PayProxy(new PayServiceImpl());
        PayServiceImpl payService = (PayServiceImpl) proxy.getPayProxy();
        payService.pay("马云2", BigDecimal.TEN);
    }

}
