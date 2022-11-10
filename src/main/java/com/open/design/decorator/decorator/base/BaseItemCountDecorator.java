package com.open.design.decorator.decorator.base;

import com.open.design.decorator.bo.ShoppingCartSkuBO;
import java.math.BigDecimal;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 10:22
 * @Description
 */
public abstract class BaseItemCountDecorator implements IBaseCount {

    private IBaseCount count;

    public BaseItemCountDecorator(IBaseCount count) {
        this.count = count;
    }

    @Override
    public BigDecimal countPay(ShoppingCartSkuBO cart) {
        return count.countPay(cart);
    }
}
