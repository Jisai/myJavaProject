package com.songj.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @ClassNamee: Topic_4
 * @Description: 寻找两个正序数组的中位数
 * 时间复杂度为O(log (m+n))，看到这个时间复杂度，自然而然的想到了应该使用二分查找法来求解。
 * 那么回顾一下中位数的定义，如果某个有序数组长度是奇数，那么其中位数就是最中间那个，
 * 如果是偶数，那么就是最中间两个数字的平均值。
 * @Author: Scott S
 * @Date: 2020-08-10 11:53
 * @Version: 1.0
 **/
public class Topic_4 {

    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2};
//        int[] num1 = {1,3,7};
//        int[] num2 = {2,10};
//        int[] num1 = {1,2};
//        int[] num2 = {3,4};
        System.out.println(method_01(num1, num2));
    }


    /**
     * 利用后指针，合并俩个有序数组，合并后依旧有序。
     * 在合并后的数组找中位数。
     * 合并后的数组大小为奇数，则是第 length/2 个元素；若大小为偶数，则是第 length/2 -1 和 第 length/2 个数的和的平均数。
     * 时间复杂度是 O(m+n)，空间复杂度是 O(m+n)
     */
    public static double method_01(int[] nums1, int[] nums2) {
        //nums1 的大小
        int m = nums1.length -1;
        //nums2 的大小
        int n = nums2.length -1;
        //nums1 + nums2 的大小
        int p = nums1.length + nums2.length;
        int[] merge = new int[p];
        System.arraycopy(nums1, 0, merge, 0, nums1.length);
        System.out.println("1 merge is " + JSON.toJSONString(merge));
        while( m >= 0 && n >= 0){
            merge[--p] = merge[m] > nums2[n] ? merge[m--] : nums2[n--];
        }
        System.out.println("2 merge is " + JSON.toJSONString(merge));
        System.out.println("n = " + n);
        System.arraycopy(nums2,0, merge, 0, n+1);
        int k = merge.length / 2;
        int mod = merge.length % 2;
        System.out.println("k = " + k + " mod = " + mod);
        if(mod == 0){
            return (float) (merge[k -1] + merge[k])/2;
        }else{
            return merge[k];
        }
    }




    /**
     * @Description: 二分查找算法【官方】
     *
     */
    public double method_04(int[] nums1, int[] nums2){
        //将 nums1 值为较短的数组。
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        //分割线左边的所有元素需要满足的个数。 注意防止整型溢出：m + (n - m + 1) / 2
        int totalLeft = (m + n + 1) / 2;

        //在 num1 的区间 [0, m] 里查找恰当的分割线。
        //使得 num1[i -1] <= num2[j] && nums2[j -1] <= num1[i]
        int left = 0;
        int right = m;

        while (left < right){
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if(nums1[i - 1] > nums2[j]){
                //下一轮搜索的区间 [left, i - 1]
                right = i -1;
            }else {
                //下一轮搜索的区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft -i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i -1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j -1];
        int nums2RightMin = j == 0 ? Integer.MIN_VALUE : nums2[j];

        if(((m+n) % 2) == 1){
            return Math.max(nums1LeftMax, nums2LeftMax);
        }else {
            return (double) (Math.max(nums1LeftMax, nums1LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }




}
