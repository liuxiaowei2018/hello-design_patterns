package com.open.design.strategy.example.cost;

import java.math.BigDecimal;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:06
 * @Description 普通会员策略
 */
public class OrdinaryStrategy implements Strategy{

    @Override
    public BigDecimal compute(BigDecimal cost) {
        System.out.println("普通会员 不打折");
        return cost;
    }

    @Override
    public Integer getType() {
        return UserType.NO_VIP.getType();
    }
}
