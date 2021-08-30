package com.songj.algorithm.query;

import java.util.Arrays;

/**
 * @ClassName: FeiBoNaQie
 * @Description: 查找-斐波那契查找
 * 斐波那契数列我们都知道{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 }，前后的比值会越来越接近0.618，也就是黄金分割点。
 * 0.618也被公认为最具有审美意义的比例数字。斐波那契查找原理其实和二分法查找原理差不多，只不过计算中间值mid的方式不同，
 * 还有一点就是斐波那契查找的数组长度必须是f（k）-1，这样我们就可以把斐波那契数列进行划分，
 * f(k)-1=f(k-1)+f(k-2)-1=[f(k-1)-1]+1+[f(k-2)-1]；然后前面部分和后面部分都还可以继续进行划分。
 * 但实际上我们要查找的数组长度不可能都是f（k）-1，所以我们要补齐最后的部分，让数组的长度等于f（k）-1，
 * 让数组的最后一位数字把后面铺满。比如我们查找的数组长度是21，而f（8）-1=21-1=20；小于21，所以f（8）-1是不行的，
 * 我们需要把数组长度变为f（9）-1=34-1=33，后面多余的我们都用原数组最后的那个值填充。
 * @Author: Scott S
 * @Date: 2019/7/10 15:00
 * @Version: 1.0
 **/
public class FeiBoNaQie {

    public static int fibonacciSearch(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int length = array.length;
        int k = 0;
        while (length > fibonacci(k) - 1 || fibonacci(k) - 1 < 5) {
            k++;
        }
        int[] fb = makeFbArray(fibonacci(k) - 1);
        int[] temp = Arrays.copyOf(array, fb[k] - 1);
        for (int i = length; i < temp.length; i++) {
            //用原数组最后的值填充
            temp[i] = array[length - 1];
        }
        int low = 0;
        int hight = length - 1;
        while (low <= hight) {
            int middle = low + fb[k - 1] - 1;
            if (temp[middle] > key) {
                //要查找的值在前半部分
                hight = middle - 1;
                k = k - 1;
            } else if (temp[middle] < key) {
                //要查找的值在后半部分
                low = middle + 1;
                k = k - 2;
            } else {
                if (middle <= hight) {
                    return middle;
                } else {
                    return hight;
                }
            }
        }
        return -1;
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int[] makeFbArray(int length) {
        int[] array = new int[length];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }


    /**
     * @Description: 其实经过测试发现斐波那契查找效率并没有那么高，我们再来看一下斐波那契查找的递归实现。
     * @Param: [array, value]
     * @Return: int
     * @Author: Scott S
     * @Date: 2019/7/10 - 15:11
     **/
    public static int search(int[] array, int value) {
        if (array == null || array.length == 0) return -1;
        int length = array.length;
        int k = 0;
        while (length > fibonacci(k) - 1 || fibonacci(k) - 1 < 5) {
            k++;
        }
        int[] fb = makeFbArray(fibonacci(k) - 1);
        int[] temp = Arrays.copyOf(array, fb[k] - 1);
        for (int i = length; i < temp.length; i++) {
            temp[i] = array[length - 1];//用原数组最后的值填充
        }
        return fibonacciSearch(temp, fb, value, 0, length - 1, k);
    }

    public static int fibonacciSearch(int[] array, int[] fb, int value, int low, int hight, int k) {
        if (value < array[low] || value > array[hight] || low > hight) {
            return -1;
        }
        int middle = low + fb[k - 1] - 1;
        if (value < array[middle]) {
            return fibonacciSearch(array, fb, value, low, middle - 1, k - 1);
        } else if (value > array[middle]) {
            return fibonacciSearch(array, fb, value, middle + 1, hight, k - 2);
        } else {
            if (middle <= hight) {
                return middle;
            } else {
                return hight;
            }
        }
    }


    /**
     * @Description: 上面的两个斐波那契查找有一个缺点，就是数组长度必须是斐波那契数减1，否则数组就要增大，
     * 浪费空间。我们可以优化一下，不需要扩大数组的长度，当查找的位置大于原数组的长度的时候，
     * 我们让比较的值等于数组的最后一个元素即可。
     * @Param: [array, key]
     * @Return: int
     * @Author: Scott S
     * @Date: 2019/7/10 - 15:20
     **/
    public static int fibonacciSearch1(int[] array, int key) {
        if (array == null || array.length == 0)
            return -1;
        int length = array.length;
        int k = 0;
        while (length > fibonacci(k) - 1 || fibonacci(k) - 1 < 5) {
            k++;
        }
        int[] fb = makeFbArray(fibonacci(k) - 1);
        int low = 0;
        int hight = length - 1;
        while (low <= hight) {
            int middle = low + fb[k - 1] - 1;
            int midvalue;
            if (middle >= length) {
                midvalue = array[length - 1];
            } else {
                midvalue = array[middle];
            }
            if (midvalue > key) {
                //要查找的值在前半部分
                hight = middle - 1;
                k = k - 1;
            } else if (midvalue < key) {
                //要查找的值在后半部分
                low = middle + 1;
                k = k - 2;
            } else {
                if (middle <= hight) {
                    return middle;
                } else {
                    return hight;
                }
            }
        }
        return -1;
    }

}
