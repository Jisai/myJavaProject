package com.songj.designPattern.bulider;

/**
 * @ClassNamee: Director
 * @Description: 指挥者：调用建造者中的方法完成复杂对象的创建。
 * 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 * @Author: Scott S
 * @Date: 2020-05-28 15:39
 * @Version: 1.0
 **/
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
