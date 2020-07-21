package com.songj.designPattern.prototype.demo1;

import javax.swing.*;

/**
 * @ClassNamee: SunWukong
 * @Description: 设计模式 - 原型模式 - 示例
 * @Author: Scott S
 * @Date: 2020-05-25 14:36
 * @Version: 1.0
 **/
public class SunWukong extends JPanel implements Cloneable
{
    private static final long serialVersionUID = 5543049531872119328L;
    public SunWukong()
    {
        JLabel l1=new JLabel(new ImageIcon("src\\main\\resources\\files\\SunWukong.jpg"));
        this.add(l1);
    }

    @Override
    public Object clone()
    {
        SunWukong w=null;
        try
        {
            w=(SunWukong)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("拷贝悟空失败!");
        }
        return w;
    }
}
