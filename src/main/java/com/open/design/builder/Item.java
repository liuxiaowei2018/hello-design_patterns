package com.open.design.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 1:27
 * @Description 不同类型的商品 普通实物商品，电子卡券商品，虚拟视频学习商品 等多种不同的商品
 * 电子卡券：独有券码
 * 学习视频：独有视频链接
 */
@Setter
@Getter
@ToString
public class Item {

    // 必填
    private String itemName;
    // 必填
    private Integer type;
    // 卡券必填
    private String code;
    // 视频必填
    private String url;
}
