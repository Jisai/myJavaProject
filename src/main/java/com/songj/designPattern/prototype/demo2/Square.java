package com.songj.designPattern.prototype.demo2;

import java.util.Scanner;

/**
 * @ClassNamee: Square
 * @Description: 原型模式 - 示例 正方形
 * @Author: Scott S
 * @Date: 2020-05-25 14:45
 * @Version: 1.0
 **/
public class Square implements Shape {
    @Override
    public Object clone()
    {
        Square b = null;
        try
        {
            b=(Square)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("拷贝正方形失败!");
        }
        return b;
    }

    @Override
    public void countArea()
    {
        int a = 0;
        System.out.print("这是一个正方形，请输入它的边长：");
        Scanner input=new Scanner(System.in);
        a=input.nextInt();
        System.out.println("该正方形的面积="+a*a+"\n");
    }
}
