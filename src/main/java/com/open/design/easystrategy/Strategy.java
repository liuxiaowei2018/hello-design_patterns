package com.open.design.easystrategy;

import java.math.BigDecimal;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:04
 * @Description
 */
public interface Strategy {

    //计费
    BigDecimal compute(BigDecimal cost);

    //返回Type
    Integer getType();

}
