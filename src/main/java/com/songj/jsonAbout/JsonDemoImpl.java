package com.songj.jsonAbout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.songj.bean.Employee;
import org.json.JSONArray;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName: JsonTest01
 * @Description: 测试
 * @Author: Scott S
 * @Date: 2019/5/22 16:58
 * @Version: 1.0
 **/
public class JsonDemoImpl implements JsonDemo {


    /**
     * @Description: 对象转字符串
     **/
    @Test
    @Override
    public void objectToString(){
        Employee employee = getEmployeeDemo();
        String objStr1 = JSONUtil.objectToJSON(employee);
        System.out.println("第一种方式：");
        System.out.println(objStr1);
    }

    /**
     * @Description: 对象转字符串
     **/
    @Test
    @Override
    public void listToJson(){
        List<Employee> list = getList(2);
        System.out.println(" = = = = = >> one << = = = = = ");
        System.out.println(JSONObject.toJSON(list).toString());
        System.out.println(" = = = = = >> two << = = = = = ");
        System.out.println(new JSONArray(list).toString());
    }

    /**
     * @Description: 字符串转对象，然后取出属性值。
     * 方法一：导入谷歌的Gson包
     *
     **/
    @Test
    @Override
    public void stringToObject1(){
        String testStr = "{'code':403,'status':'error','message':'invalid userId or videoId.','data':''}";
        Gson gson = new Gson();
        Map map = gson.fromJson(testStr, Map.class);
        System.out.println(map.get("status"));
    }

    /**
     * @Description: 字符串转对象，然后取出属性值。
     * 方法二：导入阿里的FastJson包
     *
     **/
    @Test
    @Override
    public void stringToObject2(){
        String testStr = "{'code':403,'status':'error','message':'invalid userId or videoId.','data':''}";
        JSONObject jsonObject = JSON.parseObject(testStr);
        System.out.println(jsonObject.get("status"));
    }

    /**
     * @Description: 字符串转对象，然后取出属性值。
     * 方法二：导入阿里的FastJson包
     *
     **/
    @Test
    @Override
    public void stringToObject3(){
        String testStr = "{'id':403,'name':'zhangSan','level':'1','isQuit':'true'}";
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(testStr);
        Employee employee = (Employee) net.sf.json.JSONObject.toBean(jsonObject,Employee.class);
        System.out.println(employee);
        System.out.println("employee name is " + employee.getName());
    }

    /**
     * @Description: 字符串转json，获取嵌套属性。
     **/
    @Test
    @Override
    public void stringToJSON(){
        String testStr = "{'code':200,'status':'success','message':'','data':{'token':'2eac9922558843be8539a3ead7c996c1','userId':'01b768ec8c'}}";
        JSONObject jsonObject01 = JSON.parseObject(testStr);
        JSONObject jsonObject02 = jsonObject01.getJSONObject("data");
        System.out.println("jsonObject02: " + jsonObject02);
       String token = jsonObject02.getString("token");
        System.out.println(token);
    }

    /**
     * @Description: String转Map
     **/
    @Test
    @Override
    public void stringToMap1(){
        String testStr1 = "{'code':100,'msg':,'desc':,'trance':null}";
        String testStr2 = "{'code':100,'msg':'i am msg.','desc':'i am desc.','trance':null}";
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
//        map = gson.fromJson(testStr1, map.getClass());// 报错
        map = gson.fromJson(testStr2, map.getClass());
//        Integer code1 = Integer.valueOf(map.get("code").toString());// 报错，map.get("code")拿到的值实际为100.0
        Double code2 = (Double) map.get("code");
        System.out.println(code2);
    }

    /**
     * @Description: String转Map
     **/
    @Test
    @Override
    public void stringToMap2(){
        String testStr2 = "{'code':100,'msg':'i am msg.','desc':'i am desc.','trance':null}";
        Map<String, Object> map = new HashMap<>();
        //顺序会变
        map = (Map<String, Object>) JSON.parse(testStr2);
        System.out.println(map);
    }

    /**
     * @Description: String转Map
     **/
    @Test
    @Override
    public void stringToMap3(){
        String testStr2 = "{'code':100,'msg':'i am msg.','desc':'i am desc.','trance':null}";
        Map<String, Object> map = new HashMap<>();
        //
        map = (Map<String, Object>) JSON.parse(testStr2);
        System.out.println(map);
    }


    /**
     * @Description: json字符串转Array
     **/
    @Test
    @Override
    public void jsonStringToList(){
        String jsonString = "['0.5', '0.6', '0.7']";
        List<Double> list = new ArrayList<>();
        list = JSONObject.parseArray(jsonString, Double.class);
        System.out.println(list);
    }







// ==========================       私有方法          =========================================
    /**
     * @Description: 获取一个Employee的对象示例。
     * 字符串，空字符串，数值，布尔值，空，null
     **/
    private Employee getEmployeeDemo(){
        Employee result = new Employee();
        result.setId(123456);
        result.setName("我是名称");
        result.setPositionTitle("");
        result.setQuit(true);
        result.setSalary(null);
        return result;
    }

    private List<Employee> getList(int size){
        List<Employee> list = new ArrayList<>();
        for(int i = 0; i <size; i++){
            Employee one = new Employee();
            one.setId(i);
            one.setName("我是名称");
            one.setPositionTitle("");
            one.setQuit(true);
            one.setSalary(null);
            list.add(one);
        }
        System.out.println(UUID.randomUUID().toString());
        return list;
    }

}
