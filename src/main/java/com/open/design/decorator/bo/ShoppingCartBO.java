package com.open.design.decorator.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liuxiaowei
 * @date 2022年11月09日 15:46
 * @Description 购物车
 */
@Data
@Accessors(chain = true)
public class ShoppingCartBO {

    /**
     * 购物车id
     */
    private Long id;

    /**
     * 购物车商品
     */
    private List<ShoppingCartSkuBO> skuList;

    /**
     * 满减促销
     */
    private List<SupportPromotionBO> supportPromotions;

    /**
     * 满减金额
     */
    private BigDecimal fullReduce;

    /**
     * 总支付金额(skuList::promoPrice::reduce->sum - fullReduce)
     */
    private BigDecimal totalPay;

}
