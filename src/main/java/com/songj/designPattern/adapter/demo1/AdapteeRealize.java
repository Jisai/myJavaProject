package com.songj.designPattern.adapter.demo1;

/**
 * @ClassNamee: AdapteeRealize
 * @Description: 适配者实现
 * @Author: Scott S
 * @Date: 2020-05-29 15:40
 * @Version: 1.0
 **/
public class AdapteeRealize implements TwoWayAdaptee {
    @Override
    public void specificRequest() {
        System.out.println("适配者代码被调用！");
    }
}