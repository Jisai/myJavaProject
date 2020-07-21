package com.songj.designPattern.bulider;

/**
 * @ClassNamee: ConcreteBuilder
 * @Description: 具体建造者：实现了抽象建造者接口。
 * 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * @Author: Scott S
 * @Date: 2020-05-28 15:37
 * @Version: 1.0
 **/
public class ConcreteBuilder extends Builder {

    @Override
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建造 PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建造 PartC");
    }
}
