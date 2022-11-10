package com.open.design.decorator.promotion.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 12:05
 * @Description 优惠券
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCoupon {

    /**
     * 优惠券ID
     */
    private int id;

    /**
     * 领取优惠券用户ID
     */
    private int userId;

    /**
     * 优惠金额
     */
    private BigDecimal coupon;
}
