package com.open.design.decorator.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liuxiaowei
 * @date 2022年11月09日 15:49
 * @Description 购物车商品
 */
@Data
@Accessors(chain = true)
public class ShoppingCartSkuBO {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 商品ID
     */
    private Long itemId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 规格描述
     */
    private String attr;

    /**
     * 原价
     */
    private BigDecimal retailPrice;

    /**
     * 促销价格(实际商品价格)
     */
    private BigDecimal promoPrice;

    /**
     * 单品促销
     */
    private List<SupportPromotionBO> supportPromotions;

}
