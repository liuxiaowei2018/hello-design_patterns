package com.open.design.decorator.enums;

/**
 * @author liuxiaowei
 * @date 2022年11月09日 16:02
 * @Description
 */
public enum PromotionType {

    // --------------单品-----------------

    /**
     * 0-无促销，常规品
     */
    NORMAL,

    /**
     * 1-单品折扣
     */
    SINGLE_DISCOUNT,

    /**
     * 2-买赠
     */
    BUY_GIFT,

    /**
     * 3-组合 (多维度 代码逻辑里其实没有这个类型)
     */
    PACKAGE,

    /**
     * 6-秒杀
     */
    SECKILL,

    /**
     * 8-预售
     */
    PRE_SALE,

    /**
     * 11-拼团
     */
    JOIN_GRP,

    /**
     * 12-中奖
     */
    LOTTERY,

    /**
     * 14-会员价
     */
    VIP_PRICE,


    // --------------整单-----------------

    /**
     * 4-满赠
     */
    FULL_GIFT,

    /**
     * 5-满减
     */
    FULL_MINUS,

    /**
     * 7-满件
     */
    FULL_COUNT,

    /**
     * 15-支付减
     */
    PAY_DISCOUNT,

    /**
     * 88-优惠券(优惠券如果设置为不与促销共享，表示当前订单中有任何以上形式的促销（除了支付减），都不能适用该券)
     */
    COUPON;

}
