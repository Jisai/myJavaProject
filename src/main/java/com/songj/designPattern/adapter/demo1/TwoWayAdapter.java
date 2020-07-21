package com.songj.designPattern.adapter.demo1;

/**
 * @ClassNamee: TwoWayAdapter
 * @Description: 双向适配器
 * @Author: Scott S
 * @Date: 2020-05-29 15:42
 * @Version: 1.0
 **/
public class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;

    public TwoWayAdapter(TwoWayTarget target) {
        this.target = target;
    }

    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }

    @Override
    public void specificRequest() {
        target.request();
    }
}