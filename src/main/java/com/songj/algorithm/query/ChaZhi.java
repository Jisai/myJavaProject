package com.songj.algorithm.query;

import org.junit.Test;

/**
 * @ClassName: ChaZhi
 * @Description: 【查找 - 插值查找】
 * 二分法查然效率很高，但我们为什么要和中间的值进行比较，如果我们和数组1/4或者3/4部分的值进行比较可不可以呢，
 * 对于一个要查找的数我们不知道他大概在数组的什么位置的时候我们可以使用二分法进行查找。
 * 但如果我们知道要查找的值大概在数组的最前面或最后面的时候使用二分法查找显然是不明智的。
 * 比如我们查字典的时候如果是a或者b开头的我们一般会在前面找，如果是y或者z开头的我们一般偏向于往后面找，
 * 这个时候如果我们使用二分法从中间开始找显然是不合适的。
 * 之前二分法查找的时候我们比较的是中间值，mid=low+1/2*(high-low);
 * 但插值查找的时候我们比较的不是中间值，是mid=low + ((key - a[low]) / (a[high] - a[low])) * (high - low)。
 * @Author: Scott S
 * @Date: 2019/7/2 15:39
 * @Version: 1.0
 **/
public class ChaZhi {

    @Test
    public void test06() {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int mid = 0;
        int low = 0;
        int key = 5;
        int high = 3;
        // = 0 + ((5 - 10) / (7 - 10)) * (3 - 0)
        mid = low + ((key - a[low]) / (a[high] - a[low])) * (high - low);
        System.out.println(0 + ((5 - 10) / (7 - 10)) * (3 - 0));
        System.out.println(mid);
    }

    public static int insertSearch01(int[] array, int key) {
        return search(array, key, 0, array.length - 1);
    }

    private static int search(int[] array, int key, int left, int right) {
        while (left <= right) {
            if (array[right] == array[left]) {
                if (array[right] == key) {
                    return right;
                } else {
                    return -1;
                }
            }
            int middle = left + ((key - array[left]) / (array[right] - array[left])) * (right - left);
            if (array[middle] == key) {
                return middle;
            }
            if (key < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    //递归的版本
    public static int insertSearch02(int[] array, int key) {
        return search2(array, key, 0, array.length - 1);
    }

    private static int search2(int array[], int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (array[right] == array[left]) {
            if (array[right] == key) {
                return right;
            } else {
                return -1;
            }
        }
        int mid = left + (key - array[left]) / (array[right] - array[left]) * (right - left);
        if (array[mid] == key) {
            return mid;
        }
        if (array[mid] > key) {
            return search2(array, key, left, mid - 1);
        }
        return search2(array, key, mid + 1, right);
    }

}
