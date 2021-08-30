package com.songj.designPattern.adapter;

/**
 * @ClassNamee: ObjectAdapterTest
 * @Description: 客户端代码
 * 说明：对象适配器模式中的“目标接口”和“适配者类”的代码同类适配器模式一样，只要修改适配器类和客户端的代码即可。
 * @Author: Scott S
 * @Date: 2020-05-29 15:18
 * @Version: 1.0
 **/
public class ObjectAdapterTest {

    public static void main(String[] args) {
        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
