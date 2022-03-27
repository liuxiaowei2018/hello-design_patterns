package com.open.design.easystrategy;

import java.math.BigDecimal;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:17
 * @Description 白银会员策略
 */
public class SilverStrategy implements Strategy{
    @Override
    public BigDecimal compute(BigDecimal cost) {
        System.out.println("白银会员 优惠50元");
        return cost.subtract(BigDecimal.valueOf(50));
    }

    @Override
    public Integer getType() {
        return UserType.SILVER_VIP.getType();
    }
}
