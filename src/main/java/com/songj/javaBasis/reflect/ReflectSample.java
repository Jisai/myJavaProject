package com.songj.javaBasis.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassNamee: ReflectSample
 * @Description:
 * @Author: Scott S
 * @Date: 2020-11-01 22:40
 * @Version: 1.0
 **/
public class ReflectSample {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class cl = Class.forName("com.songj.javaBasis.reflect.Robot");
        Robot robot = (Robot) cl.newInstance();
        System.out.println("Class name is " + cl.getName());

        //getDeclaredMethod 可以获取该类的所有方法，不能获取该类继承和所实现接口的方法。方法私有方法时，调用需要使用setAccessible(true)
        Method eye = cl.getDeclaredMethod("eye", String.class);
        eye.setAccessible(true);
        Object obj = eye.invoke(robot,"robot_1" );
        System.out.println("private method eye result is " + obj);

        //getMethod 可以获取该类的所有的public方法，包括该类继承和所实现接口的方法，不能获取非public方法。
        Method sayHello = cl.getMethod("sayHello", String.class);
        sayHello.invoke(robot, "robot_2");

        Field name = cl.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot, "Alice");
        sayHello.invoke(robot, "robot_3");

    }
}
