package com.open.design.decorator.decorator.base;

import com.open.design.decorator.bo.ShoppingCartBO;
import com.open.design.decorator.bo.ShoppingCartSkuBO;

import java.math.BigDecimal;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 10:19
 * @Description
 */
public class BaseCount implements IBaseCount {

    @Override
    public BigDecimal countPay(ShoppingCartSkuBO sku) {
        // 促销价初始化为原价
        sku.setPromoPrice(sku.getRetailPrice());
        return sku.getPromoPrice();
    }

    @Override
    public BigDecimal countPay(ShoppingCartBO cart) {
        // 满减初始化为0
        cart.setFullReduce(BigDecimal.ZERO);
        return cart.getFullReduce();
    }
}
