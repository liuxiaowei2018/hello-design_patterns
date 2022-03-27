package com.open.design.factory.factorymethod.tip001;

import com.open.design.factory.simplefactory.tip001.IPay;

public class PayService {

    public void pay(String payType) {
        FactoryMethod aFactory = new AFactory();
        IPay pay = aFactory.createPay(payType);

    }

}
