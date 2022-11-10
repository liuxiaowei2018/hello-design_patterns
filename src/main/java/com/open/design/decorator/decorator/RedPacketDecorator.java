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
 * @Description 红包(中奖)
 */
@Slf4j
public class RedPacketDecorator extends BaseItemCountDecorator {

    private SupportPromotionBO supportPromotion;

    public RedPacketDecorator(IBaseCount count, SupportPromotionBO supportPromotion) {
        super(count);
        this.supportPromotion = supportPromotion;
    }

    @Override
    public BigDecimal countPay(ShoppingCartSkuBO sku) {
        super.countPay(sku);
        return countRedPacketPay(sku);
    }

    @Override
    public BigDecimal countPay(ShoppingCartBO cart) {
        return cart.getFullReduce();
    }

    private BigDecimal countRedPacketPay(ShoppingCartSkuBO sku) {
        log.info("-----------------------红包折扣计算-----------------------");
        BigDecimal redPacket = supportPromotion.getUserRedPacket().getRedPacket();
        log.info("红包折扣[{}]", redPacket);
        sku.setPromoPrice(sku.getPromoPrice().subtract(redPacket).setScale(2, BigDecimal.ROUND_HALF_UP));
        log.info("红包折扣后商品价格[{}]", sku.getPromoPrice());
        return sku.getPromoPrice();
    }

}
