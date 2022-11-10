package com.open.design.decorator.decorator.base;

import com.open.design.decorator.bo.ShoppingCartBO;
import com.open.design.decorator.bo.ShoppingCartSkuBO;

import java.math.BigDecimal;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 10:19
 * @Description
 */
public interface IBaseCount {

    BigDecimal countPay(ShoppingCartSkuBO sku);

    BigDecimal countPay(ShoppingCartBO cart);
}
