package com.songj.designPattern.prototype;

/**
 * @ClassNamee: RealizetypeTest
 * @Description: 设计模式 - 原型模式 - Realizetype 测试类
 * @Author: Scott S
 * @Date: 2020-05-25 13:56
 * @Version: 1.0
 **/
public class RealizetypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype  real_1 = new Realizetype();
        Realizetype  real_2 = (Realizetype) real_1.clone();
        System.out.println("real_1 == real_2 is " + (real_1 == real_2));

    }

}
