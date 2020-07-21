package com.songj.designPattern.singleton.demo1;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassNamee: BajieTest
 * @Description: 单例模式 - 饿汉单例模式测试
 * @Author: Scott S
 * @Date: 2020-05-25 14:13
 * @Version: 1.0
 **/
public class BajieTest {
    public static void main(String[] args)
    {
        JFrame jf=new JFrame("饿汉单例模式测试");
        jf.setLayout(new GridLayout(1,2));
        Container contentPane=jf.getContentPane();
        Bajie obj1=Bajie.getInstance();
        contentPane.add(obj1);
        Bajie obj2=Bajie.getInstance();
        contentPane.add(obj2);
        if(obj1==obj2)
        {
            System.out.println("他们是同一人！");
        }
        else
        {
            System.out.println("他们不是同一人！");
        }
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
