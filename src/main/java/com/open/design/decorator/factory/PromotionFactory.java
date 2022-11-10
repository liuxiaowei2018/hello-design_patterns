package com.open.design.decorator.factory;

import com.open.design.decorator.bo.ShoppingCartBO;
import com.open.design.decorator.bo.ShoppingCartSkuBO;
import com.open.design.decorator.bo.SupportPromotionBO;
import com.open.design.decorator.decorator.CouponDecorator;
import com.open.design.decorator.decorator.DiscountDecorator;
import com.open.design.decorator.decorator.RedPacketDecorator;
import com.open.design.decorator.decorator.base.BaseCount;
import com.open.design.decorator.decorator.base.IBaseCount;
import com.open.design.decorator.enums.PromotionType;
import com.open.design.decorator.promotion.full.UserCoupon;
import com.open.design.decorator.promotion.item.UserDiscount;
import com.open.design.decorator.promotion.item.UserRedPacket;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 10:18
 * @Description
 */
@Slf4j
public class PromotionFactory {

    public static void main(String[] args) {
        ShoppingCartBO cart = new ShoppingCartBO().setId(123456L);
        cart.setSkuList(getCartSkus());
        cart.setSupportPromotions(genSupportPromotions3(cart.getId()));
        for (ShoppingCartSkuBO sku : cart.getSkuList()) {
            log.info("商品明细id-[{}],商品名称-[{}]",sku.getSkuId(),sku.getName());
            BigDecimal payMoney = PromotionFactory.getPayMoney(sku);
            log.info("最终支付金额:[{}]",payMoney);
            log.info("最终支付金额核对:[{}]",sku.getPromoPrice());
        }
        BigDecimal reduceSum = cart.getSkuList().stream().map(ShoppingCartSkuBO::getPromoPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        log.info("最终商品合计花费金额:[{}]",reduceSum);
        BigDecimal fullReduce = PromotionFactory.getPayMoney(cart);
        log.info("最终满减合计金额:[{}]",fullReduce);
        // 最终价格
        log.info("最终支付价格:{}",reduceSum.subtract(fullReduce));

    }

    private static List<ShoppingCartSkuBO> getCartSkus() {
        List<SupportPromotionBO> supportPromotionslist1 = genSupportPromotions1(1L);
        List<ShoppingCartSkuBO> skus = new ArrayList<>();
        ShoppingCartSkuBO sku1 = new ShoppingCartSkuBO();
        sku1.setSkuId(1L);
        sku1.setName("红富士苹果");
        sku1.setItemId(1001L);
        sku1.setRetailPrice(new BigDecimal(70));
        sku1.setSupportPromotions(supportPromotionslist1);
        skus.add(sku1);

        List<SupportPromotionBO> supportPromotionslist2 = genSupportPromotions2(2L);
        ShoppingCartSkuBO sku2 = new ShoppingCartSkuBO();
        sku2.setSkuId(2L);
        sku2.setName("西瓜");
        sku2.setItemId(1002L);
        sku2.setRetailPrice(new BigDecimal(50));
        sku2.setSupportPromotions(supportPromotionslist2);
        skus.add(sku2);
        return skus;
    }

    private static List<SupportPromotionBO> genSupportPromotions1(Long skuId) {
        List<SupportPromotionBO> list = new LinkedList<SupportPromotionBO>();

        UserRedPacket userRedPacket = new UserRedPacket(1, 11, skuId, new BigDecimal(10));
        list.add(new SupportPromotionBO()
                .setPromotionType(PromotionType.LOTTERY)
                .setPriority(3)
                .setUserRedPacket(userRedPacket));

        UserDiscount userDiscount = new UserDiscount(3, 11, skuId, 80);
        list.add(new SupportPromotionBO()
                .setPromotionType(PromotionType.SINGLE_DISCOUNT)
                .setPriority(4)
                .setUserDiscount(userDiscount));

        UserDiscount userDiscount1 = new UserDiscount(2, 11, skuId, 90);
        list.add(new SupportPromotionBO()
                .setPromotionType(PromotionType.SINGLE_DISCOUNT)
                .setPriority(1)
                .setUserDiscount(userDiscount1));
        return list;
    }

    private static List<SupportPromotionBO> genSupportPromotions2(Long skuId) {
        List<SupportPromotionBO> list = new LinkedList<SupportPromotionBO>();

        UserRedPacket userRedPacket = new UserRedPacket(1, 11, skuId, new BigDecimal(5));
        list.add(new SupportPromotionBO()
                .setPromotionType(PromotionType.LOTTERY)
                .setPriority(3)
                .setUserRedPacket(userRedPacket));
        UserDiscount userDiscount = new UserDiscount(2, 11, skuId, 75);
        list.add(new SupportPromotionBO()
                .setPromotionType(PromotionType.SINGLE_DISCOUNT)
                .setPriority(4)
                .setUserDiscount(userDiscount));
        return list;
    }

    private static List<SupportPromotionBO> genSupportPromotions3(Long cartId) {
        List<SupportPromotionBO> list = new LinkedList<>();

        UserCoupon userCoupon = new UserCoupon(1, 11, new BigDecimal(3));
        list.add(new SupportPromotionBO()
                .setPromotionType(PromotionType.COUPON)
                .setPriority(2)
                .setUserCoupon(userCoupon));

        return list;
    }

    public static BigDecimal getPayMoney(ShoppingCartSkuBO sku) {

        // 获取给商品设定的促销类型
        List<SupportPromotionBO> supportPromotionsSorted = sku.getSupportPromotions()
                .stream()
                .sorted(Comparator.comparing(SupportPromotionBO::getPriority))
                .collect(Collectors.toList());
        // 初始化计算类
        IBaseCount baseCount = new BaseCount();
        if (supportPromotionsSorted.size() > 0) {
            // 遍历设置的促销类型，通过装饰器组合促销类型
            for (SupportPromotionBO supportPromotions : supportPromotionsSorted) {
                baseCount = protmotion(supportPromotions, baseCount);
            }
        }
        return baseCount.countPay(sku);
    }

    public static BigDecimal getPayMoney(ShoppingCartBO cart) {

        // 获取给商品设定的促销类型
        List<SupportPromotionBO> supportPromotionsSorted = cart.getSupportPromotions()
                .stream()
                .sorted(Comparator.comparing(SupportPromotionBO::getPriority))
                .collect(Collectors.toList());
        // 初始化计算类
        IBaseCount baseCount = new BaseCount();
        if (supportPromotionsSorted.size() > 0) {
            // 遍历设置的促销类型，通过装饰器组合促销类型
            for (SupportPromotionBO supportPromotions : supportPromotionsSorted) {
                baseCount = protmotion(supportPromotions, baseCount);
            }
        }
        return baseCount.countPay(cart);
    }

    /**
     * 组合促销类型
     *
     * @param supportPromotion
     * @param baseCount
     * @return
     */
    private static IBaseCount protmotion(SupportPromotionBO supportPromotion, IBaseCount baseCount) {
        if (supportPromotion.getPromotionType() == PromotionType.COUPON) {
            baseCount = new CouponDecorator(baseCount, supportPromotion);
        } else if (supportPromotion.getPromotionType() == PromotionType.LOTTERY) {
            baseCount = new RedPacketDecorator(baseCount, supportPromotion);
        } else if (supportPromotion.getPromotionType() == PromotionType.SINGLE_DISCOUNT) {
            baseCount = new DiscountDecorator(baseCount, supportPromotion);
        }
        return baseCount;
    }
}
