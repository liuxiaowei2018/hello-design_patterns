package com.open.design.strategy.example.pay;

import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * @Description: 借用Spring种提供的InitializingBean接口，这个接口为Bean提供了属性初始化后的处理方法，它只包括afterPropertiesSet方法
 * 凡是继承该接口的类，在bean的属性初始化后都会执行该方法。
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:50
 */
public class ParticularlyVipPayService implements UserPayService, InitializingBean {

    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        if (orderPrice.compareTo(BigDecimal.valueOf(30)) == -1) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calPrice(BigDecimal orderPrice, String vipType) {
        UserPayService strategy = UserPayServiceStrategyFactory.getByUserType(vipType);
        return strategy.quote(orderPrice);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserPayServiceStrategyFactory.register("ParticularlyVip",this);
    }
}
