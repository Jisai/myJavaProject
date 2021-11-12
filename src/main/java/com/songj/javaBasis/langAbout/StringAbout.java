package com.songj.javaBasis.langAbout;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassNamee: StringAbout
 * @Description:
 * @Author: Scott S
 * @Date: 2020-04-22 18:29
 * @Version: 1.0
 **/
public class StringAbout {

    public static void main(String[] args) {
        String table = "first_table";
        String tableCamelCase = StrUtil.toCamelCase(table);
        System.out.println("tableCamelCase： " + tableCamelCase);
        String tableFirstAndAddPre = StrUtil.upperFirstAndAddPre(tableCamelCase, "");
        System.out.println("tableFirstAndAddPre： " + tableFirstAndAddPre);

        String s1 = "anhgdkifg";
        String s2 = "abcdefghijkl";
        System.out.println( (s1.charAt(5) - 'a') );
        System.out.println( (s2.charAt(5) - 'a') );
    }


    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     */
    @Test
    public void autoGenericCode() {
        String code = "1234";
        int num = 6;
        String result = "";
        // 保留num的位数
        // 0 代表前面补充0
        // num 代表长度为4
        // d 代表参数为正数型
        result = String.format("%0" + num + "d", Integer.parseInt(code));

        System.out.println(result);;
    }

    @Test
    public void testNew(){
        String s = new String("a");
        s.intern();
        String s2 = "aa";
        System.out.println(s == s2);

        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3 == s4);
    }


    @Test
    public void length(){
        String a = "你好";
        String b = "你好！";
        String c = "你 好";
        System.out.println(a.length());
        System.out.println(b.length());
        System.out.println(c.length());
    }

    @Test
    public void replace(){
        String template = "[用户名模板]";
        String target = "宋吉赛";
        String msg = "[用户名模板]你好，我是活动20210414165220200250000000640011推广素材信息 。";
        msg = msg.replace(template, target);
//        System.out.println(msg);


        String target2 = "你好啊，我叫#Param1#， 我今年#Param2#岁了，我来自#Param3#，我得家乡#Param3#很美！";
        Map<String, String> paramMap2 = new HashMap<>();
        paramMap2.put("#Param1#", "小明");
        paramMap2.put("#Param2#", "11");
        paramMap2.put("#Param3#", "青岛");
        for(String key : paramMap2.keySet()){
            StrUtil.replaceChars(target2, key, paramMap2.get(key));
        }
        System.out.println(target2);
    }


    @Test
    public void startsWith(){
//        String a = "5/6/428/1100569/";
//        String b = "5/6/428/1100569/1100573/";
//        System.out.println(a.startsWith(b));
//        System.out.println(b.startsWith(a));
        String str1 = "abcdafea";
        str1.length();
        str1.toCharArray();

        String target = "a";
        int second = str1.indexOf(target, 2);
        System.out.println(second);
        String sub = str1.substring(0, second);
//        System.out.println(sub);
//        System.out.println(str1.charAt(2));
    }

    @Test
    public void split(){
        String a = "a;b;c;d";
        String b = "1;2;3;4;; ";
        String c = "1;2;3;4;;";
        String[] arr_a = a.split(";");
        String[] arr_b = b.split(";");
        String[] arr_c = c.split(";");
        System.out.println(arr_a.length);//4
        System.out.println(JSON.toJSONString(arr_a));
        System.out.println(arr_b.length);//6
        System.out.println(JSON.toJSONString(arr_b));
        System.out.println(arr_c.length);//4
        System.out.println(JSON.toJSONString(arr_c));
    }

    @Test
    public void subString(){
        String str = "TX20211011023051";
        System.out.println(str.substring(12, 18));

        String testStr1 = "爱学习教育集团/平台事业部/平台营销中心/分公司销售部/长沙销售组/";
        String testStr2 = "爱学习教育集团/平台事业部/平台营销中心/分公司销售部/长沙销售组/ ";
        String [] strArr1 = testStr1.split("/");
        String [] strArr2 = testStr2.split("/");
        System.out.println("strArr1: " + JSON.toJSONString(strArr1));
        System.out.println("strArr2: " + JSON.toJSONString(strArr2));
        System.out.println(strArr1.length);
        System.out.println( (strArr1[strArr1.length -2] + "/" + strArr1[strArr1.length -1]) );;
    }

    @Test
    public void compareInclude(){
        String parentCoopArea = "10067747,10067748;10115224,10119789,10120021";
        String[] parentArr = {""};
        if(StringUtils.isNotBlank(parentCoopArea)){

            parentArr = parentCoopArea.split(";");
        }
        String childCoopArea = "10007362;10067747,10067748;10115224,10119789,10120021";
        String[] childArr = {""};
        List<String> childArrUpdate = new ArrayList<>();
        if(StringUtils.isNotBlank(childCoopArea)){
            childArr = childCoopArea.split(";");
        }
        for(int i = 1; i <= childArr.length; i++){
            String b = childArr[i-1];
            boolean sign = false;
            for(int j = 1; j <= parentArr.length; j++){
                String a = parentArr[j-1];
                if(b.startsWith(a) && !"".equals(a)){
                    sign = true;
                }
                if(!b.startsWith(a) && (j == parentArr.length)){
                    continue;
                }
            }
            if(sign){
                childArrUpdate.add(b);
            }
        }
        String childCoopAreaUpdate = CollectionUtils.isNotEmpty(childArrUpdate) ? StringUtils.join(childArrUpdate, ";") : "";
        if(parentCoopArea.equals(childCoopArea) || childCoopArea.equals(childCoopAreaUpdate)){
            System.out.println("1>>" + childCoopAreaUpdate);
        }else {
            System.out.println("2>>" + childCoopAreaUpdate);
        }
    }

    @Test
    public void testEquals(){
        String a = null;
        System.out.println(a.equals(""));

    }




}
