package com.songj.designPattern.proxy;

/**
 * @ClassNamee: Proxy
 * @Description: 设计模式 - 代理模式 - 代理（Proxy）类：
 * 提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
 * @Author: Scott S
 * @Date: 2020-05-28 16:38
 * @Version: 1.0
 **/
public class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void Request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    public void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
