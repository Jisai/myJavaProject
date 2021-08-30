package com.songj.designPattern.adapter;

/**
 * @ClassNamee: AdapterTest
 * @Description: 客户端代码
 * @Author: Scott S
 * @Date: 2020-05-29 14:41
 * @Version: 1.0
 **/
public class AdapterTest {

    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
