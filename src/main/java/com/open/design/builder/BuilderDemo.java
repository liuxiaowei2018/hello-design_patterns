package com.open.design.builder;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 1:35
 * @Description
 */
public class BuilderDemo {

    public static void main(String[] args) {
        ItemConcreteBuilder builder = new ItemConcreteBuilder();
        ItemDirector director = new ItemDirector(builder);
        Item item = director.cardInit();
        Item item1 = director.videoInit();
        System.out.println(item);
        System.out.println(item1);

        // 省略导演类写法，如下
        ItemConcreteBuilder builder1 = new ItemConcreteBuilder();
        builder1.buildNormals();
        Item item2 = builder1.getItem();
        System.out.println(item2);
    }
}
