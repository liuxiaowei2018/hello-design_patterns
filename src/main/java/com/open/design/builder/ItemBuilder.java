package com.open.design.builder;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 1:27
 * @Description 抽象建造者类
 */
public abstract class ItemBuilder {

    protected Item item = new Item();

    public abstract void buildNormals();
    public abstract void buildCard();
    public abstract void buildVideo();

    public Item getItem() {
        return item;
    }
}
