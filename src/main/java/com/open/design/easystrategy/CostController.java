package com.open.design.easystrategy;

import java.math.BigDecimal;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:21
 * @Description
 */
public class CostController {

    //后续代码优化上，若是 Java 项目，可以尝试使用自定义注解，注解 Strategy 实现类。

    //这样可以简化原来需在工厂类 List 添加一个 Stratey 策略。

    public static void main(String[] args) {
        getResult(new BigDecimal(1500), 2);
    }

    private static BigDecimal getResult(BigDecimal money, Integer type) {

        //1000元以下不享受折扣
        if (money.compareTo(BigDecimal.valueOf(1000)) == -1) {
            return money;
        }

        Strategy strategy = StrategyFactory.getInstance().get(type);

        if (strategy == null){
            throw new IllegalArgumentException("please input right type");
        }

        return strategy.compute(money);
    }

}
