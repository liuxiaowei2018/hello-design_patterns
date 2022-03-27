package com.open.design.strategy.tip001;

import org.springframework.stereotype.Component;

@Component
public class AliPayStrategy implements PayStrategy {

    @Override
    public void pay(String userId) {
        System.out.println("AliPayStrategy userId: " + userId);
    }

}
