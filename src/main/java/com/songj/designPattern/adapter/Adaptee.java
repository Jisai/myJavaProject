package com.songj.designPattern.adapter;

/**
 * @ClassNamee: Adaptee
 * @Description: 适配者接口
 * 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 * @Author: Scott S
 * @Date: 2020-05-29 14:38
 * @Version: 1.0
 **/
public class Adaptee {

    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}
