package com.songj.designPattern.adapter.demo1;

/**
 * @ClassNamee: TwoWayAdapterTest
 * @Description: 客户端代码
 * 适配器模式（Adapter）通常适用于以下场景。
 *          以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致。
 *          使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同。
 * 模式的扩展：适配器模式（Adapter）可扩展为双向适配器模式，
 *          双向适配器类既可以把适配者接口转换成目标接口，也可以把目标接口转换成适配者接口。
 * @Author: Scott S
 * @Date: 2020-05-29 15:42
 * @Version: 1.0
 **/
public class TwoWayAdapterTest {
    public static void main(String[] args)
    {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdaptee adaptee=new AdapteeRealize();
        TwoWayTarget target=new TwoWayAdapter(adaptee);
        target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        target=new TargetRealize();
        adaptee=new TwoWayAdapter(target);
        adaptee.specificRequest();
    }
}
