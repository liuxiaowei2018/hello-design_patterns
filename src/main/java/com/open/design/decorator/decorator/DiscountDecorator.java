package com.open.design.decorator.decorator;

import com.open.design.decorator.bo.ShoppingCartBO;
import com.open.design.decorator.bo.ShoppingCartSkuBO;
import com.open.design.decorator.bo.SupportPromotionBO;
import com.open.design.decorator.decorator.base.BaseItemCountDecorator;
import com.open.design.decorator.decorator.base.IBaseCount;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 12:12
 * @Description 折扣
 */
@Slf4j
public class DiscountDecorator extends BaseItemCountDecorator {

    private SupportPromotionBO supportPromotion;

    public DiscountDecorator(IBaseCount count, SupportPromotionBO supportPromotion) {
        super(count);
        this.supportPromotion = supportPromotion;
    }

    @Override
    public BigDecimal countPay(ShoppingCartSkuBO sku) {
        super.countPay(sku);
        return countDiscountPay(sku);
    }

    @Override
    public BigDecimal countPay(ShoppingCartBO cart) {
        return cart.getFullReduce();
    }

    private BigDecimal countDiscountPay(ShoppingCartSkuBO sku) {
        log.info("-----------------------单品折扣计算-----------------------");
        double discount = supportPromotion.getUserDiscount().getDiscount();
        log.info("单品折扣[{}]", discount / 100);
        BigDecimal multiply = sku.getPromoPrice().multiply(new BigDecimal(discount / 100));
        sku.setPromoPrice(multiply.setScale(2, BigDecimal.ROUND_HALF_UP));
        log.info("折扣后商品价格[{}]", sku.getPromoPrice());
        return sku.getPromoPrice();
    }

}
