package com.songj.designPattern.prototype.demo2;

import java.util.Scanner;

/**
 * @ClassNamee: Circle
 * @Description: 原型模式 - 示例 圆
 * @Author: Scott S
 * @Date: 2020-05-25 14:44
 * @Version: 1.0
 **/
public class Circle implements Shape {

    @Override
    public Object clone()
    {
        Circle w = null;
        try
        {
            w = (Circle)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("拷贝圆失败!");
        }
        return w;
    }

    @Override
    public void countArea()
    {
        int r=0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner input=new Scanner(System.in);
        r=input.nextInt();
        System.out.println("该圆的面积="+3.1415*r*r+"\n");
    }
}
