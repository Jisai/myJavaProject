package com.songj.designPattern.factoryMethod.demo1;

//具体工厂：养马场
public class HorseFarm implements AnimalFarm{

    @Override
    public Animal newAnimal()
    {
        System.out.println("【工厂方法 - 具体工厂】新马出生！");
        return new Horse();
    }
}
