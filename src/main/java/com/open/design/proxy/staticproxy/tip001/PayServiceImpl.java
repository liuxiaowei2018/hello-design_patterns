package com.open.design.proxy.staticproxy.tip001;

import java.math.BigDecimal;

public class PayServiceImpl implements PayService {

    @Override
    public void pay(String username, BigDecimal money) {
        System.out.println(username + "支付了" + money + "元钱");
    }

}
