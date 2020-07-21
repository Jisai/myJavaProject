package com.songj.javaBasis;

/**
 * @ClassName: BodyB
 * @Description: 子类
 * @Author: Scott S
 * @Date: 2019/6/28 18:48
 * @Version: 1.0
 **/
public class BodyB extends BodyA{


    public static void staticMethod(){
        System.out.println("子类 —— 静态方法");
    }
    static {
        System.out.println("子类 —— 静态代码块");
    }

    {
        System.out.println("子类 —— 非静态代码块");
    }

    public BodyB() {
        System.out.println("子类 —— 无参构造函数");
    }
}
