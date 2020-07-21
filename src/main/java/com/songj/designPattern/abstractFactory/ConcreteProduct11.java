package com.songj.designPattern.abstractFactory;

/**
 * @ClassNamee: ConcreteProduct11
 * @Description: 设计模式 - 抽象工厂 - 具体产品
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它 同具体工厂之间是多对一的关系。
 * @Author: Scott S
 * @Date: 2020-05-26 14:40
 * @Version: 1.0
 **/
public class ConcreteProduct11 implements Product1 {

    @Override
    public void show() {
        System.out.println("我是 抽象工厂 - 具体产品1。");
    }
}
