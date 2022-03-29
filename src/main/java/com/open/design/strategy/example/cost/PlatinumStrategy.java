package com.open.design.strategy.example.cost;

import java.math.BigDecimal;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:20
 * @Description 白金会员策略
 */
public class PlatinumStrategy implements Strategy{

    @Override
    public BigDecimal compute(BigDecimal cost) {
        System.out.println("白金会员 优惠50元，再打7折");
        return (cost.subtract(BigDecimal.valueOf(50))).multiply(BigDecimal.valueOf(0.7));
    }

    @Override
    public Integer getType() {
        return UserType.PLATINUM_VIP.getType();
    }
}
