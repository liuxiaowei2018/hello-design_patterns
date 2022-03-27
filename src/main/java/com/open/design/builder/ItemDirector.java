package com.open.design.builder;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 1:33
 * @Description 导演类
 */
public class ItemDirector {

    private ItemBuilder itemBuilder;

    public ItemDirector(ItemBuilder itemBuilder) {
        this.itemBuilder = itemBuilder;
    }

    public Item normalInit() {
        itemBuilder.buildNormals();
        return itemBuilder.getItem();
    }
    public Item cardInit() {
        itemBuilder.buildCard();
        return itemBuilder.getItem();
    }
    public Item videoInit() {
        itemBuilder.buildVideo();
        return itemBuilder.getItem();
    }

}
