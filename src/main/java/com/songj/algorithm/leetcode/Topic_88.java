package com.songj.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassNamee: Topic_88
 * @Description: 合并两个有序数组
 * @Author: Scott S
 * @Date: 2020-08-11 14:39
 * @Version: 1.0
 **/
public class Topic_88 {

    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6};
        int i = 5;
        System.out.println(arr[i--]);
        System.out.println(i);
    }




    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
//        System.out.println(Arrays.toString(method_1(nums1, m, nums2, n)));
//        System.out.println(Arrays.toString(method_2(nums1, m, nums2, n)));
        System.out.println(Arrays.toString(method_3(nums1, m, nums2, n)));
    }

    /**
     * 1.0 新建一个数组。
     * 2.0 对数组1 和 数组2 分别指定一个头指针。
     * 3.1 分别根据俩个头指针遍历俩个数组，比较大小，较小的值放入新数组，同时该数值所对应的指针数加1。
     * 3.2 重复3.1操作，直至俩个指针分别遍历完俩个数组。
     */
    public static int[] method_1(int[] nums1, int m, int[] nums2, int n) {
        int [] num1_back = new int[m];
        System.arraycopy(nums1, 0, num1_back, 0, m);
        int p = 0;
        int q = 0;
        int k = 0;
        while(p < m || q < n){
            int a1 = p < m ? num1_back[p] : Integer.MAX_VALUE;
            int a2 = q < n ? nums2[q] : Integer.MAX_VALUE;
            int a3 = 0;
            if(a1 < a2){
                a3 = a1;
                p++;
            }else{
                a3 = a2;
                q++;
            }
            nums1[k] = a3;
            k++;
        }
        System.out.println("k= " + k);
        return nums1;
    }

    /*
     * @Description: 双指针 / 从前往后  -- 官方
     * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)的时间复杂度。
     * 最直接的算法实现是将指针p1 置为 nums1 的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
     * 由于 nums1 是用于输出的数组，需要将 nums1 中的前 m 个元素放在其他地方，也就需要 O(m) 的空间复杂度。
     *
     *  复杂度分析：时间复杂度 : O(n + m)。        空间复杂度 : O(m)。
     */
    public static int[] method_2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n)){
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums1_copy));
        // if there are still elements to add
        //当 p1 或者 p2 任意一个已提前到达对应数组尾部，则另一个数组的剩余部分无须再比较。
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }

        return nums1;
    }
    /*
     * @Description: 双指针 / 从后往前  -- 官方
     *
     *一般而言，对于有序数组可以通过 双指针法 达到O(n + m)的时间复杂度。
     * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
     * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m) 的空间复杂度。
     *
     *  复杂度分析：时间复杂度 : O(n + m)。        空间复杂度 : O(1)。
     */
    public static int[] method_3(int[] nums1, int m, int[] nums2, int n){
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0)){
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }

    public  static int[] method_4(int[] nums1, int m, int[] nums2, int n){
        int i = m + n -1;
        m--;
        n--;
        while(n >= 0){
            if(m>=0 && nums1[m]>nums2[n]){
                nums1[i] = nums1[m];
                m--;
            }else{
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
        return nums1;
    }

}
