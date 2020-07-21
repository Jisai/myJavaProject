package com.songj.otherAbout;

import com.alibaba.fastjson.JSON;
import com.songj.bean.People;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * @ClassName: TestOneMain
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2018-06-06 17:18
 * @Version: 1.0
 */
public class TestOneMain {

    @Test
    public void test01(){
        Map<Integer, Set<String>> result = new HashMap<>();
        List<String> list = Arrays.asList("a","b","c","d","e","f","a1","b1","c1","d1","e1","f1");
        Set<String> insIdListByAll =  new HashSet<>(list);

        //按照分公司可开发区域匹配到的机构id集合
        List<String> list1 = Arrays.asList("a","b","c","d");
        Set<String> insIdListByDepartArea = new HashSet<>(list1);
        result.put(1, insIdListByDepartArea);
        insIdListByAll.removeAll(insIdListByDepartArea);
        //按照分公司可开发区域的省匹配到的机构id集合
        List<String> list2 = Arrays.asList("c","d","e","f","a1","b1","c1");
        Set<String> insIdListByProvince = new HashSet<>(list2);
        Set<String> insIdListByRemainAll = new HashSet<>(insIdListByAll);
        insIdListByProvince.retainAll(insIdListByRemainAll);
        Set<String> insIdListByProvinceReal = new HashSet<>(insIdListByProvince);
        if(result.keySet().contains(1) && CollectionUtils.isNotEmpty(result.get(1))){
            Set<String> insIdListByDept = result.get(1);
            insIdListByDept.addAll(insIdListByProvinceReal);
            result.put(1, insIdListByDept);
        }else {
            result.put(1, insIdListByProvinceReal);
        }
        insIdListByAll.removeAll(insIdListByProvinceReal);
        result.put(-1, insIdListByAll);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testSwitch(){
        String result = "";
        Integer code = null;
        switch (code){
//        case null: result = "null";
            case 1:
                result = "1";
                break;
            case 2: result = "2";
                break;
            default:  result = "null";
        }
        System.out.println(result);
    }




}
