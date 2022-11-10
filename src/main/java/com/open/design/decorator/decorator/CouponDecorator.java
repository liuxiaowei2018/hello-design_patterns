package com.open.design.decorator.decorator;

import com.open.design.decorator.bo.ShoppingCartBO;
import com.open.design.decorator.bo.ShoppingCartSkuBO;
import com.open.design.decorator.bo.SupportPromotionBO;
import com.open.design.decorator.decorator.base.BaseFullCountDecorator;
import com.open.design.decorator.decorator.base.IBaseCount;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 10:24
 * @Description 优惠券计算装饰器
 */
@Slf4j
public class CouponDecorator extends BaseFullCountDecorator {

    private SupportPromotionBO supportPromotion;

    public CouponDecorator(IBaseCount count, SupportPromotionBO supportPromotion) {
        super(count);
        this.supportPromotion = supportPromotion;
    }

    @Override
    public BigDecimal countPay(ShoppingCartSkuBO sku) {
        return sku.getPromoPrice();
    }

    @Override
    public BigDecimal countPay(ShoppingCartBO cart) {
        super.countPay(cart);
        return countCouponPay(cart);
    }

    private BigDecimal countCouponPay(ShoppingCartBO cart) {
        log.info("-----------------------优惠券计算-----------------------");
        BigDecimal coupon = supportPromotion.getUserCoupon().getCoupon();
        log.info("优惠券金额[{}]", coupon);
        cart.setFullReduce(cart.getFullReduce().add(coupon));
        log.info("优惠券后合计整单满减价格[{}]", cart.getFullReduce());
        return cart.getFullReduce();
    }

}
