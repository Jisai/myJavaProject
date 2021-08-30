package com.songj.algorithm.leetcode;

import java.io.Serializable;

/**
 * @ClassNamee: Topic_733   https://leetcode-cn.com/problems/flood-fill/
 * @Description:  图像渲染
 * @Author: Scott S
 * @Date: 2021-07-20 11:56
 * @Version: 1.0
 **/
public class Topic_733 {


    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;

    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startVal = image[sr][sc];
        if(image[sr][sc] == newColor){
            return image;
        }
        search(image, sr,  sc, startVal, newColor);
        image[sr][sc] = newColor;
        return image;
    }

    private void search(int[][] image, int sr, int sc, int startVal, int newColor){
        if(sr < 0  || sr > image.length -1 || sc < 0 || sc > image[sr].length-1 || image[sr][sc] != startVal){
            return;
        }
        image[sr][sc] = newColor;
        //上
        search(image, sr-1, sc, startVal, newColor);
        //下
        search(image, sr+1, sc, startVal, newColor);
        //左
        search(image, sr, sc -1, startVal, newColor);
        //右
        search(image, sr, sc+1, startVal, newColor);
    }

}
