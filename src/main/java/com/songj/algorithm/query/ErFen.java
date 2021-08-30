package com.songj.algorithm.query;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @ClassName: ErFen
 * @Description: 【查找 - 二分查找】
 * 二分法查找适用于大的数据，但前提条件是数据必须是有序的。
 * 他的原理是先和中间的比较，如果等于就直接返回，如果小于就在前半部分继续使用二分法进行查找，
 * 如果大于则在后半部分继续使用二分法进行查找……
 * @Author: Scott S
 * @Date: 2019/6/26 11:58
 * @Version: 1.0
 **/
public class ErFen {

    @Test
    public void testMain(){

    }






    /**
     * @Description: 二分法查找数值所在有序数组的下标[while循环的方式]，找不到返回-1。
     * @Param: [array -- 待查找的范围数组, value -- 被查找的值]
     * @Return: int
     * @Author: Scott S
     * @Date: 2019/7/1 - 14:39
     **/
    public int binarySearch01(int[] array, int value){
        int low = 0;
        int high = array.length -1;
        while (low <= high){
            int moddel = low + ((high - low) >> 1);
            //最好不要使用注释的部分，因为当数组比较大的时候，low+high可能会溢出。
//            int moddel = (low + high) >> 1;
            if(value == array[moddel]){
                return moddel;
            }else if(value > array[moddel]){
                low = moddel + 1;
            }else {
                high = moddel - 1;
            }
        }
        return -1;
    }

    /**
     * @Description: 二分法查找数值所在有序数组的下标[递归的方式]，找不到返回-1。
     * @Param: [array -- 待查找的范围数组, value -- 被查找的值]
     * @Return: int
     * @Author: Scott S
     * @Date: 2019/7/1 - 14:39
     **/
    public int binarySearch02(int[] array, int value){
        int low = 0;
        int high = array.length -1;
        return searchmy(array, low, high, value);
    }

    public int searchmy(int[] array, int low, int high, int value){
        if(low > high){
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if(value == array[mid]){
            return mid;
        }
        if(value < array[mid]){
            return searchmy(array, low, mid - 1, value);
        }
        return searchmy(array, mid + 1, high, value);
    }





    /**
     * @Description: 获取数组中与目标targetNum值最接近的比例组合
     * @Param: [ratioArray - 按照有小到大排好序的数组, ratioMap - 对应ratioArray下标的比例组合 , targetNum - 目标值]
     * @Return:  与目标targetNum值最接近的比例组合
     * @Author: Scott S
     * @Date: 2019/5/31 - 9:38
     **/
    public String getTargetSuitableRatio(double[] ratioArray, Map<Integer, String> ratioMap , double targetNum){
        int leftIndex = 0;
        int rightIndex = ratioArray.length -1;
        int resultIndex = 0;
        while (leftIndex < rightIndex){
            int midIndex = (leftIndex + rightIndex) / 2;
            double a = ratioArray[midIndex];
            int b = compareDouble(targetNum, ratioArray[midIndex]);
            if(compareDouble(targetNum, ratioArray[midIndex]) == 1){
                //大于
                leftIndex = midIndex;
            }else if(compareDouble(targetNum, ratioArray[midIndex]) == -1){
                //小于
                rightIndex = midIndex;
            }else {
                //等于，结束判断。
                resultIndex = midIndex;
                break;
            }
            if((rightIndex - leftIndex) <= 1){
                resultIndex = Math.abs(ratioArray[leftIndex] - targetNum) <=  Math.abs(ratioArray[rightIndex] - targetNum) ? leftIndex : rightIndex;
                break;
            }
        }
        return ratioMap.get(resultIndex);
    }


    private int compareDouble(double a, double b){
        BigDecimal A = BigDecimal.valueOf(a);
        BigDecimal B = BigDecimal.valueOf(b);
        int result = A.compareTo(B);
        return result;
    }

}
