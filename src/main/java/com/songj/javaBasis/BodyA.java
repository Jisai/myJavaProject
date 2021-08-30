package com.songj.javaBasis;

/**
 * @ClassName: BodyA
 * @Description:  父类
 * @Author: Scott S
 * @Date: 2019/6/28 16:18
 * @Version: 1.0
 **/
public class BodyA {

    public static void staticMethod(){
        //被子类的相同方法覆盖。
        System.out.println("父类—— 静态方法。");
    }

    static {
        System.out.println("父类 —— 静态代码块。");
    }

    public BodyA() {
        System.out.println("父类 —— 无参构造函数");
    }

    {
        System.out.println("父类 —— 非静态代码块");
    }


    /**
     * 方法的执行顺序无非就是下面两种:
     * 第一种：
     * 父类静态块-->子类静态块-->父类非静态方法-->父类构造方法-->子类非静态方法-->子类构造方法-->子类静态方法
     * 第二种：
     * 父类静态块-->子类静态块-->子类静态方法-->父类非静态方法-->父类构造方法-->子类非静态方法-->子类构造方法
     *
     * 【总结：】
     * 1、它首先去看父类里面有没有静态代码块，如果有，它先去执行父类里面静态代码块里面的内容，
     * 当父类的静态代码块里面的内容执行完毕之后， 接着去执行子类(自己这个类)里面的静态代码块，
     * 2、当子类的静态代码块执行完毕之后，它接着又去看父类有没有非静态代码块，如果有就执行父类的非静态代码块，
     * 父类的非静态代码块执行完毕，接着执行父类的构造方法；父类的构造方法执行完毕之后，
     * 它接着去看子类有没有非静态代码块，如果有就执行子类的非静态代 码块。
     * 子类的非静态代码块执行完毕再去执行子类的构造方法，这个就是一个对象的初始化顺序
     *
     **/
    public static void main(String[] args) {
        new BodyB();
        BodyB.staticMethod();
    }



}
