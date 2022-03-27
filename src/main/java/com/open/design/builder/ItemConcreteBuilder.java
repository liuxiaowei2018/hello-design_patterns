package com.open.design.builder;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 1:27
 * @Description 抽象建造者类
 */
public class ItemConcreteBuilder extends ItemBuilder{


    @Override
    public void buildNormals() {
        item.setItemName("普通商品");
        item.setType(1);
    }

    @Override
    public void buildCard() {
        item.setItemName("卡券商品");
        item.setCode("123456");
        item.setType(2);
    }

    @Override
    public void buildVideo() {
        item.setItemName("视频");
        item.setType(3);
        item.setUrl("http://www.baidu.com");
    }
}
