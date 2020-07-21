package com.songj.designPattern.prototype;

/**
 * @ClassNamee: Realizetype
 * @Description: 设计模式 - 原型模式
 * @Author: Scott S
 * @Date: 2020-05-25 13:52
 * @Version: 1.0
 **/
public class Realizetype implements Cloneable {

    public Realizetype(){
        System.out.println("具体原型创建成功！");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();
    }
}
