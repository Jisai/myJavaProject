package com.songj.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassNamee: MaoPao
 * @Description: 经典排序
 * https://www.cnblogs.com/guoyaohua/p/8600214.html
 * https://blog.csdn.net/xiaoxiaojie12321/article/details/81380834
 **/
public class JingDianPaiXu {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,8,2,3,9,4};
        //均按照有小到大排序。
        System.out.println("冒泡：" + Arrays.toString(bubbleSort(arr)));
        System.out.println("选择：" + Arrays.toString(selectionSort(arr)));
        System.out.println("插入：" + Arrays.toString(insertionSort(arr)));
        System.out.println("希尔：" + Arrays.toString(shellSort(arr)));
        System.out.println("归并：" + Arrays.toString(mergeSort(arr)));
    }



    /**
     * @Description: 冒泡排序（正序）
     * 冒泡排序比较所有相邻的两个项，如果第一个比第二个大，则交换它们。
     * 内层循环减去 i 的原因：从内循环减去外循环中已跑过的轮数，就可以避免内循环中所有不必要的比较。
     */
    public static int[] bubbleSort(int[] arr) {
        if(arr.length < 2){return arr;}
        for (int i = 0; i < arr.length -1; i++) {
            //！！！相邻的值依次互相比较，元素大的值往后放。
            for (int j = 0; j < arr.length -1 -i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * @Description: 选择排序
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     */
    public static int[] selectionSort(int[] arr){
        if(arr.length < 2){return arr;}
        int min;
        for(int i = 0; i < arr.length -1; i++){
            min = i;
            //！！！起始值 i 依次和后面的值比较，元素小的值往前放。
            for(int j = i; j < arr.length - 1; j++){
                if(arr[i] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    /**
     * @Description: 插入排序
     * ①从第一个元素开始，该元素可以认为已经被排序；
     * ②取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * ③如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * ④重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * ⑤将新元素插入到该位置后；
     * ⑥重复步骤2~5。
     */
    public static int[] insertionSort(int[] arr){
        if(arr.length < 2){return arr;}
        int current;
        for(int i = 0; i < arr.length-1; i++){
            //!!!当前需要比较的元素值(即i+1),与前面（从i位置往前）已排好的队列比较，如果值比前面的小，将比较过的值依次往后移。
            //当前需要比较的元素值
            current = arr[i+1];
            //已排完序的队列尾下标
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]){
                //此时的 preIndex 处为 current 可能被放入的位置。
                arr[preIndex + 1] = arr[preIndex];
                preIndex --;
            }
            arr[preIndex+1] = current;
        }
        return arr;
    }

    /**
     * @Description: 希尔排序
     * ①选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * ②按增量序列个数k，对序列进行k 趟排序；
     * ③每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，
     *          分别对各子表进行直接插入排序。
     *          仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    public static int[] shellSort(int[] arr){
        if(arr.length < 2){return arr;}
        int len = arr.length;
        //步长
        int gap = len / 2;
        //待比较的值
        int current;
        while (gap > 0){
            for(int i = gap; i < len - 1; i++){
                int preIndex = i - gap;
                current = arr[i];
                while (preIndex > 0 && arr[preIndex] > current){
                    arr[i] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap = gap / 2;
        }
        return arr;
    }

    /**
     * @Description: 归并排序
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     */
    public static int[] mergeSort(int[] arr){
        if(arr.length < 2){return arr;}
        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr,0, mid);
        int[] rightArr = Arrays.copyOfRange(arr,mid, arr.length);
        mergeArr(mergeSort(leftArr), mergeSort(rightArr));
        return arr;
    }
     public static int[] mergeArr(int[] leftArr,int[] rightArr){
        int[] result = new int[leftArr.length + rightArr.length];
        for(int index=0, i=0, j =0; index < result.length; index ++){
            if(i >= leftArr.length){
                result[index] = rightArr[j++];
            }else if(j >= rightArr.length){
                result[index] = leftArr[i++];
            }else if(leftArr[i] > rightArr[j]){
                result[index] = rightArr[j++];
            }else{
                result[index] = leftArr[i++];
            }
        }
        return result;
     }




}
