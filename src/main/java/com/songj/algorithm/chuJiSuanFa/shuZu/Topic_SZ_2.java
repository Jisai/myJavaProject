package com.songj.algorithm.chuJiSuanFa.shuZu;

/**
 * @ClassNamee: Topic_SZ_2  买卖股票的最佳时机 II
 * @Description:    https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 * @Author: Scott S
 * @Date: 2022-03-09 09:35
 * @Version: 1.0
 **/
public class Topic_SZ_2 {

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(new Topic_SZ_2().maxProfit1(prices));
    }

    //动态规划解决
    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        //手里有股票
        dp[0][0] = -prices[0];
        //手里没有股票
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            //手里有股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i] );
            //手里没有股票
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] );
        }
        return dp[prices.length-1][1];
    }


    //动态规划解决 【优化 maxProfit1()】
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        //手里有股票
        int hold = -prices[0];
        //手里没有股票
        int noholed = 0;
        for(int i = 1; i < prices.length; i++){
            //手里有股票
            hold = Math.max(hold, noholed - prices[i] );
            //手里没有股票
            noholed = Math.max(noholed, hold + prices[i] );
        }
        return noholed;
    }



    /**
     * @Description: 贪心算法
     * 需要找到股票上涨的最大值和股票开始上涨的最小值。
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int total = 0, index = 0, length = prices.length;
        while (index < length) {
            //如果股票下跌就一直找，直到找到股票开始上涨为止
            while (index < length - 1 && prices[index] >= prices[index + 1]){
                index++;
            }
            //股票上涨开始的值，也就是这段时间上涨的最小值
            int min = prices[index];
            //一直找到股票上涨的最大值为止
            while (index < length - 1 && prices[index] <= prices[index + 1]){
                index++;
            }
            //计算这段上涨时间的差值，然后累加
            total += prices[index++] - min;
        }
        return total;
    }

    //贪心算法【优化maxProfit3】
    public int maxProfit4(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //原数组中如果后一个减去前一个是正数，说明是上涨的，
            //我们就要累加，否则就不累加
            total += Math.max(prices[i + 1] - prices[i], 0);
        }
        return total;
    }


}
