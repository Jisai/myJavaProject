package com.songj.designPattern.factoryMethod;



/**
 * @ClassNamee: AbstractFactory
 * @Description: 设计模式 - 工厂方法模式 - 抽象工厂
 * 抽象工厂：提供了厂品的生成方法
 * @Author: Scott S
 * @Date: 2020-05-25 15:08
 * @Version: 1.0
 **/
public interface AbstractFactory {

    public Product newProduct();
}
