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

        Method eye = cl.getDeclaredMethod("eye", String.class);
        eye.setAccessible(true);
        Object obj = eye.invoke(robot,"robot_1" );
        System.out.println("private method eye result is " + obj);

        Method sayHello = cl.getMethod("sayHello", String.class);
        sayHello.invoke(robot, "robot_2");

        Field name = cl.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot, "Alice");
        sayHello.invoke(robot, "robot_3");

    }
}
