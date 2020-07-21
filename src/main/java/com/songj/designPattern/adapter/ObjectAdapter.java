package com.songj.designPattern.adapter;

/**
 * @ClassNamee: ObjectAdapter
 * @Description: 对象适配器类
 * @Author: Scott S
 * @Date: 2020-05-29 15:17
 * @Version: 1.0
 **/
public class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
