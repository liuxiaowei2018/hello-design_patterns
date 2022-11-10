package com.open.design.decorator.promotion.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 14:29
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRedPacket {

    /**
     * 红包ID
     */
    private int id;

    /**
     * 领取用户ID
     */
    private int userId;

    /**
     * 商品SKU
     */
    private Long skuId;

    /**
     * 领取红包金额
     */
    private BigDecimal redPacket;
}
