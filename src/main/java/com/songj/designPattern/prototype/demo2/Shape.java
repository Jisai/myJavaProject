package com.songj.designPattern.prototype.demo2;

/**
 * @ClassNamee: Shape
 * @Description: 用带原型管理器的原型模式来生成包含“圆”和“正方形”等图形的原型，并计算其面积。
 * @Author: Scott S
 * @Date: 2020-05-25 14:41
 * @Version: 1.0
 **/
public interface Shape extends Cloneable {
    //拷贝
    public Object clone();
    //计算面积
    public void countArea();

}
