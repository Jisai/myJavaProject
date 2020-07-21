package com.songj.agent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassNamee: AgentTest
 * @Description:
 * @Author: Scott S
 * @Date: 2020-05-12 15:16
 * @Version: 1.0
 **/
public class AgentUtil {







    /**
     * @Description: 根据属性名获得属性值
     * @param: [o -- java Bean, fieldName -- 属性名]
     * @return: java.lang.Object
     * @auther: Scott S
     * @date: 2020/5/12 15:19
     */
    public static Object getFieldValueByName(Object o, String fieldName) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @Description: 根据属性名赋值属性值
     * @param: [obj -- java Bean, fieldName -- 属性名, value -- 属性值]
     * @return: void
     * @auther: Scott S
     * @date: 2020/5/12 15:24
     */
    public static void setFieldValueByName(Object obj, String fieldName, Object value) {
        try {
            // 获取obj类的字节文件对象
            Class c = obj.getClass();
            // 获取该类的成员变量
            Field f = c.getDeclaredField(fieldName);
            // 取消语言访问检查
            f.setAccessible(true);
            // 给变量赋值
            f.set(obj, value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
