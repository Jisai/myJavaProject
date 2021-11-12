package com.songj.jsonAbout;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.songj.model.po.Employee;
import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

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
     *项目中用到了Gson实例化实体时时间格式转换在不同的服务器上会发行改变，所以当我在本地可以正常运行时，
     * 发布到线上就不能用了（linux）,当时我还很纳闷为何报错，
     * 后来百度这个错误后才发现Gson在不同服务器上解析的时间格式不一样，所以在一开始就应该以下列方式来创建Gson对象。
     *  Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
     **/
    @Test
    @Override
    public void stringToObject1(){
        String testStr = "{'code':403,'status':'error','message':'invalid userId or videoId.','data':''}";
        Gson gson = new Gson();
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd HH:mm:ss")
//                .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
//                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//                    @Override
//                    public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
//                        try {
//                            return df.parse(json.getAsString());
//                        } catch (ParseException e) {
//                            return null;
//                        }
//                    }
//                }).create();
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
     * @Description: 字符串转对象（多层嵌套，或者泛型<泛型>）
     *
     *
     **/
    @Test
    @Override
    public void stringToObject4(){
        String json = "{'id':'1','name':'21\uD83D\uDE2F\uD83D\uDE2F'}";
        Gson gson = new Gson();
        Employee result = gson.fromJson(json, new TypeToken<Employee>(){}.getType());
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

    @Test
    @Override
    public void stringToMap4(){
        String  testStr3  = "[{'channelCode':'aa', 'strategyCode':'AA'},{'channelCode':'bb', 'strategyCode':'BB'}]";
        Map<String, String> map = cn.hutool.json.JSONUtil.parseArray(testStr3).stream().filter(Objects::nonNull).collect(
                Collectors.toMap(
                        object -> {
                            cn.hutool.json.JSONObject item = (cn.hutool.json.JSONObject) object;
                            return item.get("channelCode", String.class);
                        },
                        object -> {
                            cn.hutool.json.JSONObject item = (cn.hutool.json.JSONObject) object;
                            return item.get("strategyCode", String.class);
                        }
                )
        );
        System.out.println(map);
    }

    @Test
    @Override
    public void mapToBean1(){
        String  testStr3  = "[{'key':'id', 'value':'123'},{'key':'name', 'value':'BB'}]";
        Map<String, String> map = cn.hutool.json.JSONUtil.parseArray(testStr3).stream().filter(Objects::nonNull).collect(
                Collectors.toMap(
                        object -> {
                            cn.hutool.json.JSONObject item = (cn.hutool.json.JSONObject) object;
                            return item.get("key", String.class);
                        },
                        object -> { cn.hutool.json.JSONObject item = (cn.hutool.json.JSONObject) object;
                            return item.get("value", String.class);
                        }
                )
        );
        System.out.println("map" + map);
        Employee employee = new Employee();
        try {
            BeanUtils.populate(employee, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("employee: " + cn.hutool.json.JSONUtil.toJsonStr(employee));

    }
    @Test
    @Override
    public void mapToBean2(){
        String  testStr3  = "[{'key':'id', 'value':'123'},{'key':'name', 'value':'BB'}]";
        Map<String, String> map = cn.hutool.json.JSONUtil.parseArray(testStr3).stream().filter(Objects::nonNull).collect(
                Collectors.toMap(
                        object -> {
                            cn.hutool.json.JSONObject item = (cn.hutool.json.JSONObject) object;
                            return item.get("key", String.class);
                        },
                        object -> { cn.hutool.json.JSONObject item = (cn.hutool.json.JSONObject) object;
                            return item.get("value", String.class);
                        }
                )
        );
        System.out.println("map" + map);
        Employee employee = new Employee();

        System.out.println("employee: " + cn.hutool.json.JSONUtil.toJsonStr(employee));

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
