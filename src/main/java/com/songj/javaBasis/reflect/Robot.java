package com.songj.javaBasis.reflect;

/**
 * @ClassNamee: Robot
 * @Description:
 * @Author: Scott S
 * @Date: 2020-11-01 22:37
 * @Version: 1.0
 **/
public class Robot {
    private String name;

    public void sayHello(String who){
        System.out.println(who + " public sayHello " + name);
    }

    private void eye(String who){
        System.out.println(who + " private eye " + name);
    }
}
