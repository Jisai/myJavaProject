package com.songj.designPattern.abstractFactory;

/**
 * @Description: 设计模式 - 抽象工厂 - 抽象工厂
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
 * @auther: Scott S
 * @date: 2020/5/26 14:17
 */
public interface AbstractFactory {

    public Product1 newProduct1();
    public Product2 newProduct2();
}
