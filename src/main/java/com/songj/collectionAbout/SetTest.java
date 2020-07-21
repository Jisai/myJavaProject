package com.songj.collectionAbout;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: SetTest
 * @Description: 测试跟集合Set相关
 * @Author: Scott S
 * @Date: 2018-06-12 10:52
 * @Version: 1.0
 */
public class SetTest {


    @Test
    public void testMethod01(){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 3; i++){
            set.add(i + "");
            set.add("");
            set.add(null);
        }
        System.out.println(set.toString());
        set.remove(null);
        set.remove("");
        System.out.println(set.toString());
    }

    @Test
    public void testMethod02(){
        Set<Integer> set = new HashSet<>();
        set.add(new Integer(1));
        set.add(new Integer(2));
        set.add(new Integer(2));
        set.add(new Integer(3));
        System.out.println(set.toString());
    }

    public void  test03(){
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(4);
        set1.add(5);
        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        set2.add(9);


    }


}
