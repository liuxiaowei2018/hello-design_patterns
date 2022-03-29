package com.open.design.strategy.example.cost;

import java.math.BigDecimal;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:19
 * @Description 黄金会员策略
 */
public class GoldStrategy implements Strategy{
    @Override
    public BigDecimal compute(BigDecimal cost) {
        System.out.println("黄金会员 8折");
        return cost.multiply(BigDecimal.valueOf(0.8));
    }

    @Override
    public Integer getType() {
        return UserType.GOLD_VIP.getType();
    }
}
