package com.songj.algorithm.liKou;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassNamee: Topic_135  https://leetcode-cn.com/problems/candy/solution/fen-fa-tang-guo-by-leetcode/
 * @Description: 分发糖果
 * 输入描述:  0,1,0     输出描述:  4
 * 输入: [1,2,2]   输出描述: 4
 * 输入: [1,0,2]   输出描述: 5
 * 输入示例:  5,4,1,1     输出示例: 7
 * 输入示例:  0，4，5，2，1，0  输出示例: 13
 * @Version: 1.0
 **/
public class Topic_135 {

    @Test
    public void main() {
        int[] ratings = new int[]{3,4,5,6};
        System.out.println(candy(ratings));
    }

    /**
     * @Description: 暴力-- 官方
     * 复杂度分析：
     * 时间复杂度：O(n^2)。对于每个元素，我们最多要遍历 n 次。
     * 空间复杂度： O(n)。需要一个长度为 n 的 candies 数组。
     */
    public int candy1(int[] ratings) {
        int sum = 0;
        boolean flag = true;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        while (flag){
            flag = false;
            for(int i = 0; i < ratings.length; i++){
                if (i != ratings.length -1 && ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                    candies[i] = candies[i+1] + 1;
                    flag = true;
                }
                if (i != 0 && ratings[i] > ratings[i-1] && candies[i]<= candies[i-1]) {
                    candies[i] = candies[i-1] + 1;
                    flag = true;
                }
            }
        }
        for(int i = 0; i < candies.length; i++){
            sum += candies[i];
        }
        System.out.println(JSON.toJSONString(candies));
        return sum;
    }

    /**
     * @Description: 用两个数组-- 官方
     * 复杂度分析
     * 时间复杂度：O(n)。 left2right 和 right2left 会各更新一次。
     * 空间复杂度：O(n)。 两个数组 left2right 和 right2left 大小都为 n 。
     */
    public int candy2(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        int[] candies = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for(int i = 0; i < ratings.length-1; i++){
            //从左往右
            if(ratings[i] < ratings[i+1] &&  left2right[i] >= left2right[i+1]){
                left2right[i+1] = left2right[i] + 1;
            }
        }
        for(int i = ratings.length-1; i >0; i--){
            //从右往左
            if(ratings[i] < ratings[i-1] &&  right2left[i] >= right2left[i-1]){
                right2left[i-1] = right2left[i] + 1;
            }
        }
        for(int i = 0; i < ratings.length; i++){
            candies[i] = Math.max(left2right[i], right2left[i]);
            sum += candies[i];
        }
        System.out.println(JSON.toJSONString(candies));
        return sum;
    }

    /**
     * @Description: 使用一个数组,跟candy2()类似。-- 官方
     * 复杂度分析
     * 时间复杂度：O(n) 。长度为 n 数组 candies 被遍历了 3 次。
     * 空间复杂度：O(n) 。数组 candies 长度为 n 。
     */
    public int candy3(int[] ratings) {
        int sum = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i = 1; i < ratings.length; i++){
            //从左往右
            if(ratings[i-1] < ratings[i]){
                candies[i] = candies[i-1] + 1;
            }
        }
        sum = candies[ratings.length - 1];
        for(int i = ratings.length-2; i >=0; i--){
            //从右往左
            if(ratings[i] > ratings[i+1] &&  candies[i] <= candies[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            sum += candies[i];
        }
        sum += candies[ratings.length-1];
        System.out.println(JSON.toJSONString(candies));
        return sum;
    }

    /**
     * @Description: 常数空间一次遍历-- 官方
     */
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                System.out.println("i=" + i + " rating=" + ratings[i] + " up=" + up + " down=" + down + " old_slope"+ old_slope + " new_slope="+ new_slope);
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0){
                up++;}
            if (new_slope < 0){
                down++;}
            if (new_slope == 0){
                candies++;}

            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }

    public int count(int n) {
        return (n * (n + 1)) / 2;
    }
}
