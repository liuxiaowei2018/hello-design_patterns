package com.open.design.factory.factorymethod.tip001;

import com.open.design.factory.simplefactory.tip001.IPay;

public interface FactoryMethod {

    IPay createPay(String payType);

}
