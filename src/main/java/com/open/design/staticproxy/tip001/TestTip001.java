package com.open.design.staticproxy.tip001;

import java.math.BigDecimal;

public class TestTip001 {

    public static void main(String[] args) {
        PayService payService = new PayServiceImpl();
        PayProxy payProxy = new PayProxy(payService);
        payProxy.pay("马云", BigDecimal.TEN);
    }

}
