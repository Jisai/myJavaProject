package com.songj.javaBasis.langAbout;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNamee: StringAbout
 * @Description:
 * @Author: Scott S
 * @Date: 2020-04-22 18:29
 * @Version: 1.0
 **/
public class StringAbout {


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
        String b = "1;2;3;4";
        String[] arr_a = a.split(";");
        String[] arr_b = b.split(";");
        System.out.println(JSON.toJSONString(arr_a));
        System.out.println(JSON.toJSONString(arr_b));
    }

    @Test
    public void subString(){
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



}
