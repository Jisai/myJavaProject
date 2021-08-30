package com.songj.designPattern.prototype.demo2;

import java.util.HashMap;

/**
 * @ClassNamee: ProtoTypeManager
 * @Description: 原型模式 - 原型模式管理器
 * 原型模式可扩展为带原型管理器的原型模式，它在原型模式的基础上增加了一个原型管理器 PrototypeManager 类。
 * 该类用 HashMap 保存多个复制的原型，Client 类可以通过管理器的 get(String id) 方法从中获取复制的原型。
 * @Author: Scott S
 * @Date: 2020-05-25 14:46
 * @Version: 1.0
 **/
public class ProtoTypeManager {
    private HashMap<String, Shape>ht=new HashMap<String,Shape>();
    public ProtoTypeManager()
    {
        ht.put("Circle",new Circle());
        ht.put("Square",new Square());
    }
    public void addShape(String key,Shape obj)
    {
        ht.put(key,obj);
    }
    public Shape getShape(String key)
    {
        Shape temp=ht.get(key);
        return (Shape) temp.clone();
    }
}

