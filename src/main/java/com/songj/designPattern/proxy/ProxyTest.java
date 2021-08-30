package com.songj.designPattern.proxy;

/**
 * @ClassNamee: ProxyTest
 * @Description: 设计模式 - 代理模式 - 测试类
 * 代理模式的定义：由于某些原因需要给某对象提供一个代理以控制对该对象的访问。
 *              这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。
 * 代理模式的主要优点有：
 *              代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
 *              代理对象可以扩展目标对象的功能；
 *              代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度；
 *
 * 其主要缺点是：
 *              在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢；
 *              增加了系统的复杂度；
 * 代理模式的结构比较简单，主要是通过定义一个继承抽象主题的代理来包含真实主题，从而实现对真实主题的访问，下面来分析其基本结构和实现方法。
 * @Author: Scott S
 * @Date: 2020-05-28 16:38
 * @Version: 1.0
 **/
public class ProxyTest {
    public static void main(String[] args)
    {
        Proxy proxy=new Proxy();
        proxy.Request();
    }
}
