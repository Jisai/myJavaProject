package com.songj.designPattern.singleton.demo1;

import javax.swing.*;

/**
 * @ClassNamee: Bajie
 * @Description: 设计模式 - 单例模式 - 饿汉式 示例
 * @Author: Scott S
 * @Date: 2020-05-25 14:06
 * @Version: 1.0
 **/
public class Bajie extends JPanel {

    private static Bajie instance=new Bajie();
    private Bajie()
    {
        JLabel l1=new JLabel(new ImageIcon("src/main/resources/files/BaJie.jpg"));
        this.add(l1);
    }
    public static Bajie getInstance()
    {
        return instance;
    }

}
