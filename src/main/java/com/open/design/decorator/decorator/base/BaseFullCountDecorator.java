package com.open.design.decorator.decorator.base;

import com.open.design.decorator.bo.ShoppingCartBO;
import java.math.BigDecimal;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 10:22
 * @Description
 */
public abstract class BaseFullCountDecorator implements IBaseCount {

    private IBaseCount count;

    public BaseFullCountDecorator(IBaseCount count) {
        this.count = count;
    }

    @Override
    public BigDecimal countPay(ShoppingCartBO cart) {
        return count.countPay(cart);
    }
}
