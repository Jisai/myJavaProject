package com.songj.designPattern.factoryMethod.demo1;

//具体工厂：养牛场
public class CattleFarm implements AnimalFarm {

    @Override
    public Animal newAnimal()
    {
        System.out.println("【工厂方法 - 具体工厂】新牛出生！");
        return new Cattle();
    }
}
