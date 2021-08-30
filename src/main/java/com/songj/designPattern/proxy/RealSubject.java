package com.songj.designPattern.proxy;

/**
 * @ClassNamee: RealSubject
 * @Description: 设计模式 - 代理模式 - 真实主题
 * 真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 * @Author: Scott S
 * @Date: 2020-05-28 16:36
 * @Version: 1.0
 **/
public class RealSubject implements Subject {

    @Override
    public void Request()
    {
        System.out.println("访问真实主题方法...");
    }
}
