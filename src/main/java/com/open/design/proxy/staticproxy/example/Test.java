package com.open.design.proxy.staticproxy.example;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        PayService payService = new PayServiceImpl();
        PayProxy payProxy = new PayProxy(payService);
        payProxy.pay("马云", BigDecimal.TEN);
    }

}
