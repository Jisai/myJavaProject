package com.songj.algorithm.leetcode;

/**
 * @ClassNamee: Topic_695   https://leetcode-cn.com/problems/max-area-of-island/
 * @Description:    岛屿的最大面积
 * @Author: Scott S
 * @Date: 2021-07-20 14:27
 * @Version: 1.0
 **/
public class Topic_695 {

    public static void main(String[] args) {
        int[][]  grid =
        {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

    }



    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int sum = sumStart(grid,  i, j);
                answer = Math.max(answer, sum);
            }
        }
        return answer;
    }


    private int sumStart(int[][] grid, int i, int j){
        if(i < 0 || i > grid.length -1
                || j < 0 || j > grid[i].length -1
                || grid[i][j] == 0){
            return 0;
        }
        //避免重复计算
        grid[i][j] = 0;
        //当前 + 上 + 下 + 左 + 右
        int sum = 1 + sumStart(grid, i -1, j) + sumStart(grid, i + 1, j)
                + sumStart(grid, i, j-1) + sumStart(grid, i, j+1);
        return sum;
    }


}
