package com.open.design.factory.factorymethod.tip001;

import com.open.design.factory.simplefactory.tip001.IPay;

public class AFactory implements FactoryMethod {

    @Override
    public IPay createPay(String payType) {
        return null;
    }

}
