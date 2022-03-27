package com.open.design.factory.factorymethod.example;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 0:38
 * @Description 分享商品图片
 * 商品的类型:无SKU商品，有SKU商品，下单分享，邀请分享......等一系列的场景
 */
public interface Share {

    /**
     * 获取分享类型
     *
     * @return
     */
    String getShareFunctionType();

    /**
     * 主要流程
     * @param shareName
     * @return
     */
    String mainProcess(String shareName);
}
