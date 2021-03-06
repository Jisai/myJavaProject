package com.songj.designPattern.adapter;

/**
 * @ClassNamee: ClassAdapter
 * @Description: 类适配器类
 * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 * 适配器模式（Adapter）的定义如下：将一个类的接口转换成客户希望的另外一个接口，
 *          使得原本由于接口不兼容而不能一起工作的那些类能一起工作。适配器模式分为类结构型模式和对象结构型模式两种，
 *          前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。
 *
 * 该模式的主要优点如下。
 *          客户端通过适配器可以透明地调用目标接口。
 *          复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
 *          将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
 *
 * 其缺点是：对类适配器来说，更换适配器的实现过程比较复杂。
 * @Author: Scott S
 * @Date: 2020-05-29 14:38
 * @Version: 1.0
 **/
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request()
    {
        specificRequest();
    }

}
