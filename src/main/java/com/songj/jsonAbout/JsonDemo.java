package com.songj.jsonAbout;

public interface JsonDemo {

    /**
     * @Description: 对象转字符串
     **/
    public void objectToString();

    /**
     * @Description: List 转 json
     **/
    public void listToJson();

    /**
     * @Description: 字符串转对象，然后取出属性值。
     * 方法一：导入谷歌的Gson包
     *
     **/
    public void stringToObject1();

    /**
     * @Description: 字符串转对象，然后取出属性值。
     * 方法二：导入阿里的FastJson包
     *
     **/
    public void stringToObject2();

    /**
     * @Description: 字符串转指定对象。
     *
     *
     **/
    public void stringToObject3();

    /**
     * @Description: 字符串转对象（多层嵌套，或者泛型<泛型>）
     *
     **/
    public void stringToObject4();

    /**
     * @Description: 字符串转json，获取嵌套属性。
     **/
    public void stringToJSON();

    /**
     * @Description: String转Map
     **/
    public void stringToMap1();

    /**
     * @Description: String转Map
     **/
    public void stringToMap2();

    /**
     * @Description: String转Map
     **/
    public void stringToMap3();
    /**
     * @Description: String转Map
     **/
    public void stringToMap4();

    /**
     * @Description: json字符串转Array
     **/
    public void jsonStringToList();
}
