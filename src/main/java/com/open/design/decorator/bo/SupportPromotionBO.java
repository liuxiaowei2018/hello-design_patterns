package com.open.design.decorator.bo;

import com.open.design.decorator.enums.PromotionType;
import com.open.design.decorator.promotion.full.UserCoupon;
import com.open.design.decorator.promotion.item.UserDiscount;
import com.open.design.decorator.promotion.item.UserRedPacket;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liuxiaowei
 * @date 2022年11月09日 15:58
 * @Description
 */
@Data
@Accessors(chain = true)
public class SupportPromotionBO {

    /**
     * 促销ID
     */
    private Integer id;

    /**
     * 促销类型
     */
    private PromotionType promotionType;

    /**
     * 使用优先级
     */
    private Integer priority;

    /**
     * 单品折扣
     */
    private UserDiscount userDiscount;

    /**
     * 单品红包折扣
     */
    private UserRedPacket userRedPacket;

    // --------------------------------------------------------

    /**
     * 优惠券
     */
    private UserCoupon userCoupon;

}
