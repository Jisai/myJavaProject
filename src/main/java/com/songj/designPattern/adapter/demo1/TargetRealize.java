package com.songj.designPattern.adapter.demo1;

/**
 * @ClassNamee: TargetRealize
 * @Description: 目标实现
 * @Author: Scott S
 * @Date: 2020-05-29 15:40
 * @Version: 1.0
 **/
public class TargetRealize implements TwoWayTarget {

    @Override
    public void request() {
        System.out.println("目标代码被调用！");
    }
}
