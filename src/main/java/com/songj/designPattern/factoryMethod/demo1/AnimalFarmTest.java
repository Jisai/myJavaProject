package com.songj.designPattern.factoryMethod.demo1;

/**
 * @ClassNamee: AnimalFarmTest
 * @Description:
 * @Author: Scott S
 * @Date: 2020-05-26 16:48
 * @Version: 1.0
 **/
public class AnimalFarmTest {
    public static void main(String[] args)
    {
        try
        {
            Animal a;
            AnimalFarm af;
            af=(AnimalFarm) ReadXML2.getObject();
            a=af.newAnimal();
            a.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
