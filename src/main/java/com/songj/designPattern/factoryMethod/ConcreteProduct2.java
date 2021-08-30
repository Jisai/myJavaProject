package com.songj.designPattern.factoryMethod;

/**
 * @ClassNamee: ConcreteProduct1
 * @Description: 设计模式 - 工厂方法模式 - 具体产品2
 * @Author: Scott S
 * @Date: 2020-05-25 15:09
 * @Version: 1.0
 **/
public class ConcreteProduct2 implements Product{


    @Override
    public void show() {
        System.out.println("具体产品2显示...");
    }
}
