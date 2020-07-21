package com.songj.algorithm.query;

import org.junit.Test;

/**
 * @ClassName: ShunXu
 * @Description: 201 【查找 - 顺序查找】
 * 查找算法中顺序查找算是最简单的了，无论是有序的还是无序的都可以，也不需要排序，只需要一个个对比即可，但其实效率很低。
 * @Author: Scott S
 * @Date: 2019/6/26 11:29
 * @Version: 1.0
 **/
public class ShunXu {

    @Test
    public void testSearch2(){
        int[] a = {3,6,8,9,2};
        System.out.println(search2(a, 8));
    }


    public static int search1(int[] a, int key) {
        for (int i = 0, length = a.length; i < length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @Description: 如果找到就返回查找的数所在数组中的下标，如果没找到就返回-1。
     * 还有说上面的代码可以优化，使用一个哨兵，免去了每次都要越界的判断，
     * 但通过实际测试运行效率并没有提高，无论测试的数据是多还是少运行的时间都差不多
     **/
    public static int search2(int[] a, int key) {
        int index = a.length - 1;
        if (key == a[index]) {
            return index;
        }
        a[index] = key;
        int i = 0;
        while (a[i++] != key){} ;
        return i == index + 1 ? -1 : i - 1;
    }

}
