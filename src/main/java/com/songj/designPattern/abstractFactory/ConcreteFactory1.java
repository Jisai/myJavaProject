package com.songj.designPattern.abstractFactory;

/**
 * @ClassNamee: ConcreteFactory1
 * @Description: 设计模式 - 抽象工厂 - 具体工厂
 * 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
 * @Author: Scott S
 * @Date: 2020-05-26 14:50
 * @Version: 1.0
 **/
public class ConcreteFactory1 implements AbstractFactory {

    @Override
    public Product1 newProduct1()
    {
        System.out.println("具体工厂 1 生成-->具体产品 11...");
        return new ConcreteProduct11();
    }
    @Override
    public Product2 newProduct2()
    {
        System.out.println("具体工厂 1 生成-->具体产品 21...");
        return new ConcreteProduct21();
    }
}
