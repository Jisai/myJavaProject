package com.songj.collectionAbout;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * @ClassName: MapTest
 * @Description: 测试跟集合Map相关
 * @Author: Scott S
 * @Date: 2018-05-16 14:01
 * @Version: 1.0
 */
public class MapTest {


    public void testHashTable(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        Hashtable<Integer, String> hashtable = new Hashtable<>();
    }


    /**
     * 验证Map 的 containsKey 方法可以查询几层？
     * 结果只循环最外层。
     * @return
     */
    @Test
    public void containsKeyTest(){
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("1","1");
        map1.put("2","2");
        map1.put("3","3");
        map1.put("4","4");
        Map<String, Object> map101 = new HashMap<String, Object>();
        map101.put("101","101");
        map101.put("102","2102");
        map1.put("5",map101);
        System.out.println(map1.containsKey("102"));
    }

    /**
     * 验证List强转Map,key是什么
     */
    @Test
    public void listToMapTest(){
        List<String> testList = Lists.newArrayList();
        testList.add("我是数组元素01");
        testList.add("我是数组元素02");
        testList.add("我是数组元素03");
        testList.add("我是数组元素04");
        Object testObject = (Object) testList;
        /*报错：
            Exception in thread "main" java.lang.ClassCastException: java.util.ArrayList cannot be cast to java.util.Map
	        at com.songj.collectionAbout.MapTest.test02(MapTest.java:53)
	        at com.songj.collectionAbout.MapTest.main(MapTest.java:22)
         */
        Map testMap = (Map) testObject;
        System.out.println("数组的key集：" + testMap.keySet());
    }

    /**
     * 验证重复put同一个key，结果如何
     *  不报错，覆盖掉原来的数据。
     */
    @Test
    public void putTest(){
        Map<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");
        map.put("f","f");
        List<String> removeList = Arrays.asList("a", "b");
        System.out.println(map.get("a"));
        System.out.println("keySet1 >> " + map.keySet().toString());
        System.out.println("map1 >> " + map.toString());
        map.keySet().removeIf(key -> removeList.contains(key));
        System.out.println("keySet2 >> " + map.keySet().toString());
        System.out.println("map2 >> " + map.toString());
    }

    /**
     * 循环输出map中的元素
     */
    @Test
    public void test04(){
        Map<String, String> maps = new HashMap<>();
        maps.put("name", "小红");
        maps.put("age", "12");
        maps.put("adderss", "China");
        maps.put("isBoy", "true");
        boolean sign = true;
        String url = "https://www.baidu.com";
        for(String param : maps.keySet()){
            if(sign){
                url += "?" + param + "=" + maps.get(param);
                sign = false;
            }else {
                url += "&" + param + "="  + maps.get(param);
            }
        }
        System.out.println(url);
    }


    @Test
    public void sortMap(){
        // 创建一个字符串为Key，数字为值的map
        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);
        System.out.println("排序前: " + budget);
        // 按值排序 升序
        Map<String, Integer> sorted = budget
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        System.out.println("升序按值排序后的map: " + sorted);
        String obj = null;
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            obj = entry.getKey();
            if (obj != null) {
                break;
            }
        }
        System.out.println("升序按值排序后的map第一个元素:" + obj);


        // 按值排序降序
        sorted = budget
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        System.out.println("降序按值排序后的map: " + sorted);
    }


}
