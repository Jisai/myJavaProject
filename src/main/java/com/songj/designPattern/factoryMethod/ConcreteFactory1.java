package com.songj.designPattern.factoryMethod;

/**
 * @ClassNamee: ConcreteFactory1
 * @Description: 设计模式 - 工厂方法模式 - 具体工厂1
 * 具体工厂1：实现了厂品的生成方法
 * @Author: Scott S
 * @Date: 2020-05-25 15:12
 * @Version: 1.0
 **/
public class ConcreteFactory1 implements AbstractFactory {

    @Override
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}
