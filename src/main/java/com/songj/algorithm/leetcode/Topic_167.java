package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_167   https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @Description:    两数之和 II - 输入有序数组
 * @Author: Scott S
 * @Date: 2021-07-16 19:49
 * @Version: 1.0
 **/
public class Topic_167 {


    /**双指针
     * 初始时两个指针分别指向第一个元素位置和最后一个元素的位置。
     * 每次计算两个指针指向的两个元素之和，并和目标值比较。
     * 如果两个元素之和等于目标值，则发现了唯一解。
     * 如果两个元素之和小于目标值，则将左侧指针右移一位。
     * 如果两个元素之和大于目标值，则将右侧指针左移一位。
     * 移动指针之后，重复上述操作，直到找到答案。
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }



    /**二分查找
     * 在数组中找到两个数，使得它们的和等于目标值，可以首先固定第一个数，
     * 然后寻找第二个数，第二个数等于目标值减去第一个数的差。
     * 利用数组的有序性质，可以通过二分查找的方法寻找第二个数。
     * 为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找。
     */
    public int[] twoSum_2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

}
