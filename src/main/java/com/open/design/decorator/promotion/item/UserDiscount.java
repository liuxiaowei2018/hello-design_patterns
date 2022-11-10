package com.open.design.decorator.promotion.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuxiaowei
 * @date 2022年11月10日 12:07
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDiscount {

    /**
     * 折扣ID
     */
    private int id;

    /**
     * 领取折扣用户ID
     */
    private int userId;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 折扣-10表示1折
     */
    private double discount;

}
