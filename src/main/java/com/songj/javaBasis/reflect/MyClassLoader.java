package com.songj.javaBasis.reflect;

import java.io.*;

/**
 * @ClassNamee: MyClassLoader
 * @Description:
 * @Author: Scott S
 * @Date: 2021-05-17 10:03
 * @Version: 1.0
 **/
public class MyClassLoader extends ClassLoader{

    private String path;

    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader() {
    }

    //用于寻找类文件
    @Override
    public Class findClass(String name){
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    //用于加载类文件
    private byte[] loadClassData(String name) {
        name = path + name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;

        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i = 0;
            while ( (i = in.read()) != -1 ){
                out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }



}
