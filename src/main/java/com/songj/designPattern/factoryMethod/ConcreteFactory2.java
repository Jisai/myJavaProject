package com.songj.designPattern.factoryMethod;

/**
 * @ClassNamee: ConcreteFactory1
 * @Description: 设计模式 - 工厂方法模式 - 具体工厂2
 * 具体工厂2：实现了厂品的生成方法
 * @Author: Scott S
 * @Date: 2020-05-25 15:12
 * @Version: 1.0
 **/
public class ConcreteFactory2 implements AbstractFactory {

    @Override
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct1();
    }
}
