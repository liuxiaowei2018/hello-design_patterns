package com.open.design.strategy.example.cost;

import java.math.BigDecimal;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:21
 * @Description
 */
public class CostTest {


    public static void main(String[] args) {
        cost(new BigDecimal(1500), 2);
    }

    private static BigDecimal cost(BigDecimal money, Integer type) {

        // 前置处理
        if (money.compareTo(BigDecimal.valueOf(1000)) == -1) {
            // 1000元以下不享受折扣
            return money;
        }

        // 策略处理
        Strategy strategy = StrategyFactory.getInstance().get(type);
        if (strategy == null){
            throw new IllegalArgumentException("please input right type");
        }
        return strategy.compute(money);
    }

}
