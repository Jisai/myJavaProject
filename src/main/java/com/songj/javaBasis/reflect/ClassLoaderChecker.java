package com.songj.javaBasis.reflect;

import org.junit.Test;

/**
 * @ClassNamee: ClassLoaderChecker
 * @Description:
 * @Author: Scott S
 * @Date: 2021-05-17 10:53
 * @Version: 1.0
 **/
public class ClassLoaderChecker {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader mc = new MyClassLoader("C:/Users/songj/", "myClassLoader");
        Class cl = mc.loadClass("WangLi");
        System.out.println(cl.getClassLoader());
        cl.newInstance();
    }

    @Test
    public void testExtClassLoader(){
        String extDirPath = System.getProperty("java.ext.dirs");
        System.out.println(extDirPath);
    }
    @Test
    public void testAppClassLoader(){
        String appDirPath = System.getProperty("java.class.path");
        System.out.println(appDirPath);
    }

}
