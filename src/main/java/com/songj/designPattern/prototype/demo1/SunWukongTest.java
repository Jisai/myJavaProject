package com.songj.designPattern.prototype.demo1;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassNamee: SunWukongTest
 * @Description: 设计模式 - 原型模式 - 测试
 * @Author: Scott S
 * @Date: 2020-05-25 14:38
 * @Version: 1.0
 **/
public class SunWukongTest {

    public static void main(String[] args)
    {
        JFrame jf=new JFrame("原型模式测试");
        jf.setLayout(new GridLayout(1,2));
        Container contentPane=jf.getContentPane();
        SunWukong obj1=new SunWukong();
        contentPane.add(obj1);
        SunWukong obj2=(SunWukong)obj1.clone();
        contentPane.add(obj2);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
