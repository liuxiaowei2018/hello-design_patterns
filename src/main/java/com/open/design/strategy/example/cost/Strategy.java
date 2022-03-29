package com.open.design.strategy.example.cost;

import java.math.BigDecimal;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:04
 * @Description 抽象策略类
 */
public interface Strategy {

    /**
     * 计费
     *
     * @param cost
     * @return
     */
    BigDecimal compute(BigDecimal cost);

    /**
     * 策略类型
     *
     * @return
     */
    Integer getType();

}
