package com.songj.designPattern.bulider;

/**
 * @ClassNamee: Builder
 * @Description: 抽象建造者：包含创建产品各个子部件的抽象方法。
 * 抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * @Author: Scott S
 * @Date: 2020-05-28 15:36
 * @Version: 1.0
 **/
public abstract class Builder {

    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}
