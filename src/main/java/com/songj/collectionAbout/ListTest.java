package com.songj.collectionAbout;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.songj.model.po.ReflectDataOne;
import com.songj.model.po.ReflectDataTwo;
import com.songj.model.po.User;
import com.songj.util.BeanCopyUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: ListTest
 * @Description: 测试跟集合List相关
 * @Author: Scott S
 * @Date: 2018-06-05 13:45
 * @Version: 1.0
 */
public class ListTest {


    @Test
    public void testListCopy(){
        List<ReflectDataOne> mList = new ArrayList<>();
        ReflectDataOne m = new ReflectDataOne();
        m.setId(1);
        m.setName("小明");
        mList.add(m);

        List<ReflectDataTwo> nList1 = new ArrayList<>();
        List<ReflectDataTwo> nList2 = new ArrayList<>();
        nList1 = BeanCopyUtil.copyListProperties(mList , ReflectDataTwo::new);
        nList2 = BeanCopyUtil.copyListProperties(mList , ReflectDataTwo.class);

        System.out.println(JSONUtil.toJsonStr(nList1));
        System.out.println(JSONUtil.toJsonStr(nList2));
    }


    /**
     * subList(起始下标（包含）, 结束下标（不包含）)
     * subList不能超出list大小
     */
    @Test
    public void testSubList(){
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i < 15 ; i++){
            integerList.add(i);
        }
        System.out.println(integerList.size());
        System.out.println(integerList.toString());
        System.out.println(integerList.subList(5,10));
//        System.out.println(integerList.subList(9,15));//java.lang.IndexOutOfBoundsException: toIndex = 15
        System.out.println(integerList.subList(14,15));

        //  ==============  我是分割线================
        System.out.println(" ======================= ");
        //分配单个的最大数量
        Float numFlo = integerList.size() / (float) 4;
        Double numDou = Math.ceil(numFlo);
        Integer numInt = numDou.intValue();
        for(int i = 0; i < 4; i ++ ){
            int listStart = i*numInt;
            int listEnd = (i+1)*numInt;
            //最后一段线程会 出现与其他线程不等的情况
            if(i == numInt - 1){
                listEnd = integerList.size();
            }
            System.out.println(integerList.subList(listStart, listEnd));
        }

        //  ==============  我是分割线================
        System.out.println(" ======================= ");
        int batch = 20;
        for(int i = 0; i < Math.ceil(integerList.size() / (float) batch); i++){
            int listStart = i*batch;
            int listEnd = (i+1)*batch >= integerList.size() ? integerList.size() : (i+1)*batch;
//            System.out.println(">>" + listStart + " " + listEnd);
            System.out.println(integerList.subList(listStart, listEnd));
        }
    }

    /**
     * @Description: 按照字符分割，再按照字符对应拼接
     * @param: []
     * @return: void
     * @auther: Scott S
     * @date: 2019/12/19 15:12
     */
    @Test
    public void separation(){
        List<String> param = Arrays.asList("1,2,3;4,5,6", "7,8,9", "", null, "13");
        Set<String> result = separation(param);
        Map<String, String> nameMap = result.stream().collect(Collectors.toMap(item -> item, item -> (item + "-" + item), (key1, key2) -> key2));
        System.out.println("map:" + JSON.toJSONString(nameMap));
        //按照字符对应拼接
        for(String my1 : param){
            String my2 = new String();
            if(StringUtils.isNotBlank(my1)){
                String[] arr1 = my1.split(";");
                List<String> name1 = new ArrayList<>();
                if(arr1 != null && arr1.length > 0){
                    for (String one : arr1){
                        if(StringUtils.isNotBlank(one)){
                            String[] arr2 = one.split(",");
                            if(arr2 != null && arr2.length > 0){
                                List<String> name2 = Arrays.asList(arr2).stream().map(item -> nameMap.get(item)).collect(Collectors.toList());
                                name1.add(StringUtils.join(name2, "、"));
                            }
                        }
                    }
                }
                my2 = StringUtils.join(name1, "；");
                System.out.println("my2=" + my2);
                System.out.println("param=" + StringUtils.join(param, ";"));
            }
        }
    }

    @Test
    public void test(){
        List<String> list1 = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> list2 = Arrays.asList("bb","aa", "ac", "dd","cc");
        System.out.println(list1.containsAll(list2));
        System.out.println(list2.containsAll(list1));


    }

    @Test
    public void compareUpdate(){
        System.out.println("abc".startsWith("ab"));
        System.out.println("abc".startsWith("abcd"));
        System.out.println("abc".startsWith(""));
        //参照物   10067747,10067748;10115224,10119789,10120021
//        List<String> aList = Arrays.asList("山东,济南,历下区", "河南,郑州", "山西", "浙江,绍兴", "北京,海淀,海淀街道");
        List<String> aList = Arrays.asList("10067747,10067748", "10115224,10119789,10120021");
//        List<String> aList = Arrays.asList("");
//        List<String> aList = new ArrayList<>();
        //待参照的  10007362;10067747,10067748;10115224,10119789,10120021
//        List<String> bList = Arrays.asList("山东,济南,历下区", "河南,郑州,郑州街道", "河南,洛阳", "山西,大同", "北京,海淀");
        List<String> bList = Arrays.asList("10007362", "10067747,10067748", "10115224,10119789,10120021");
//        List<String> bList = Arrays.asList("");
//        List<String> bList = new ArrayList<>();
        //cList = bList去除没有被aList包含的。
        List<String> cList = new ArrayList<>();
        for(int i = 1; i <= bList.size(); i++){
            String b = bList.get(i-1);
            boolean sign = false;
            for(int j = 1; j <= aList.size(); j++){
                String a = aList.get(j-1);
                if(b.startsWith(a) && !"".equals(a)){
                    sign = true;
                }
                if(!b.startsWith(a) && (j == aList.size())){
                    continue;
                }
            }
            if(sign){
                cList.add(b);
            }
        }
        System.out.println(JSON.toJSONString(cList));
    }






    /**
     * @Description: 按照字符分割
     * @param: []
     * @return: void
     * @auther: Scott S
     * @date: 2019/12/19 15:12
     */
    private Set<String> separation(List<String> param){
        Set<String> result = new HashSet<>();
        System.out.println("处理前： " + JSON.toJSONString(param));
        if(CollectionUtils.isNotEmpty(param)){
            for(String one : param){
                if(StringUtils.isNotBlank(one)){
                    String[] arr1 = one.split(";");
                    if(arr1 != null && arr1.length > 0){
                        for (String two : arr1){
                            if(StringUtils.isNotBlank(two)){
                                String[] arr2 = two.split(",");
                                result.addAll(Arrays.asList(arr2));
                            }
                        }
                    }
                }
            }
        }
        System.out.println("处理后： " + JSON.toJSONString(result));
        return result;
    }



    @Test
    public void testAdd(){
        List<User> userList = getUserList(2);
        System.out.println(userList);
        User userAdd = new User();
        userAdd.setUserId(0);
        userAdd.setUserName("用测试用户add");
        userAdd.setUserAge(50);
        userAdd.setUserSalary(1000);
        userAdd.setUserSex("女");
        userList.add(0, userAdd);
        System.out.println(userList);
    }

    /**
     * List 转 String
     */
    @Test
    public void testListToString(){
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i < 5; i ++ ){
            integerList.add(i);
        }
        String integerString = StringUtils.join(integerList, ",");
        System.out.println(integerString);
    }

    /**
     * @Description: 不能为空或空字符串
     * @auther: Scott S
     * @date: 2019/12/17 11:25
     */
    @Test
    public void stringToList(){
        String a1 = "10000001,10000002,10001692,10001988";
        List<Integer> b1 = new ArrayList<>();
        b1 = Arrays.asList(a1.split(",")).stream().map(item -> Integer.valueOf(item)).collect(Collectors.toList());
        String a2 = "10000001";
        List<Integer> b2= new ArrayList<>();
        b2 = Arrays.asList(a2.split(",")).stream().map(item -> Integer.valueOf(item)).collect(Collectors.toList());
        String a3 = null;
        List<Integer> b3= new ArrayList<>();
        b3 = Arrays.asList(a3.split(",")).stream().map(item -> Integer.valueOf(item)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(b1));
        System.out.println(JSON.toJSONString(b2));
        System.out.println(JSON.toJSONString(b3));
    }



    @Test
    public void reorderListByAge(){
        List<User> userList = getUserList(5);
        System.out.println("排序前：");
        System.out.println(userList.toString());

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getUserAge() - o2.getUserAge();
            }
        });

        System.out.println("排序后：");
        System.out.println(userList.toString());
    }

    /**
     * @Description: 求两个list的交集、并集、和差集
     * addAll命令，会把第2个list中的数据添加到第一个list中。
     * retainAll命令，返回的是一个boolean值，如果结果修改了第一个list就返回true，没修改就返回false，结果会直接修改第一个list，
     *      如果第2个list是第一个的子集，就不会修改第一个list。retainAll命令返回的是两个list同时包含的内容。
     * 1、首先调用retainAll的方法。
     * 2、通过判断结果集合是否大于0，来确定是否存在交集。不能通过方法返回的True和False来判断。
     * 当集合A的大小改变的时候返回的是True,大小没有改变的时候返回的是False。
     * removeAll命令，使用第一个list的内容去减第2个list，也就是说第1个list的结果保留第2个list中没有的内容。
     * @Author: Scott S
     * @Date: 2019/3/14 - 18:32
     **/
    @Test
    public void method01 (){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List list2 = Arrays.asList(1,7,8,9);
        List list3 = Arrays.asList(4,5,6,7,8,9);

        //1.0 并集
//        List<Integer> list2_2 = new ArrayList<>(list2);
//        List<Integer> list3_2 = new ArrayList<>(list3);
//        System.out.println("并集: " + list2_2.addAll(list3_2));
//        System.out.println("list3_2 结果: " + list3_2);
//        System.out.println("list2 结果: " + list2);
//        System.out.println("并集结果: " + list2_2);
        //2.0 交集
        List<Integer> list2_2 = new ArrayList<>(list2);
//        List<Integer> list3_2 = new ArrayList<>(list3);
        List<Integer> list3_2 = new ArrayList<>();
        System.out.println("交集: " + list2_2.retainAll(list3_2));
        System.out.println("交集结果: " + list2_2);
        System.out.println(CollectionUtils.isEmpty(list2_2));
        //3.0 差集
//        System.out.println("差集: " + list2.removeAll(list3));
//        System.out.println("差集结果: " + list2);
        //4.0 无重复并集
//        list2.removeAll(list3);
//        list3.addAll(list2);
//        System.out.println("差集结果: " + list3);
//        List<Integer> list2_2 = new ArrayList<>(list2);
//        List<Integer> list3_2 = new ArrayList<>(list3);
//        list2_2.removeAll(list3_2);
//        System.out.println(list2);
//        System.out.println(list2_2);
    }

    @Test
    public void remove(){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list = new ArrayList<>(list1);
        System.out.println(JSON.toJSONString(list));
        Iterator<Integer> list_ite = list.iterator();
        while (list_ite.hasNext()){
            Integer one = list_ite.next();
            if(one.intValue() == 3){
                list_ite.remove();
            }
        }
        System.out.println(JSON.toJSONString(list));
    }




    private static List<User> getUserList(int userListSize){
        List<User> userList = new ArrayList<>();
        for(int i = 0; i < userListSize; i++){
            User user = new User();
            user.setUserId(i);
            user.setUserName("用户0" + i);
            user.setUserAge(50 - i);
            user.setUserSalary(1000 - i);
            user.setUserSex(i%2 == 0 ? "男" : "女");
            userList.add(user);
        }
        return userList;
    }


    @Test
    public void  avgAssignList1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        int n = 3;
        List<List<Integer>> result = averageAssign(list, n);
        System.out.println(JSON.toJSON(result).toString());
    }
    @Test
    public void  avgAssignList2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<String> n = Arrays.asList("a","b","c");
        Map<String, List<Integer>> result = averageAssign(list, n);
        System.out.println(JSON.toJSON(result).toString());
    }


    /**
     * 将一组数据平均分成n组
     *
     * @param source 要分组的数据源
     * @param n      平均分成n组
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

    /**
     * 将一组数据平均分成n组
     *
     * @param source 要分组的数据源
     * @param n      平均分成n组
     * @param <T>
     * @return
     */
    public static <T> Map<String ,List<T>> averageAssign(List<T> source, List<String> n) {
        Map<String, List<T>> result = new HashMap<>();
        int remainder = source.size() % n.size();  //(先计算出余数)
        int number = source.size() / n.size();  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n.size(); i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.put(n.get(i),value);
        }
        return result;
    }

    /**
     * 将一组数据固定分组，每组n个元素
     * @param source 要分组的数据源
     * @param n      每组n个元素
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> fixedGrouping(List<T> source, int n) {

        if (null == source || source.size() == 0 || n <= 0){
            return null;
        }
        List<List<T>> result = new ArrayList<List<T>>();

        int sourceSize = source.size();
        int size = (source.size() / n) + 1;
        for (int i = 0; i < size; i++) {
            List<T> subset = new ArrayList<T>();
            for (int j = i * n; j < (i + 1) * n; j++) {
                if (j < sourceSize) {
                    subset.add(source.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }

    /**
     * 将一组数据固定分组，每组n个元素
     *
     * @param source 要分组的数据源
     * @param n      每组n个元素
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> fixedGrouping2(List<T> source, int n) {

        if (null == source || source.size() == 0 || n <= 0){
            return null;
        }
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;
        int size = (source.size() / n);
        for (int i = 0; i < size; i++) {
            List<T> subset = null;
            subset = source.subList(i * n, (i + 1) * n);
            result.add(subset);
        }
        if (remainder > 0) {
            List<T> subset = null;
            subset = source.subList(size * n, size * n + remainder);
            result.add(subset);
        }
        return result;
    }




}
