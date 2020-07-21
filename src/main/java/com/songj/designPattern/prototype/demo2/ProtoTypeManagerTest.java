package com.songj.designPattern.prototype.demo2;

/**
 * @ClassNamee: ProtoTypeManagerTest
 * @Description: 设计模式 - 原型模式 - ProtoTypeManager 测试类
 * @Author: Scott S
 * @Date: 2020-05-25 14:48
 * @Version: 1.0
 **/
public class ProtoTypeManagerTest {
    public static void main(String[] args)
    {
        ProtoTypeManager pm=new ProtoTypeManager();
        Shape obj1=(Circle)pm.getShape("Circle");
        obj1.countArea();
        Shape obj2=(Shape)pm.getShape("Square");
        obj2.countArea();
    }
}
