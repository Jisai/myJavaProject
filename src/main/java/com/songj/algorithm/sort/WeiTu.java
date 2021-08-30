package com.songj.algorithm.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: Sort01
 * @Description: 排序-位图排序
 *  位图排序也称为bitmap排序，它主要用于海量数据去重和海量数据排序，
 *  假如说有10亿个int类型且全部不相同的数据，给1G内存让你排序，你怎么排，
 *  如果全部加载到内存中，相当于40亿个字节，大概约等于4G内存。
 *  所以全部加载到内存肯定不行，如果我们使用位图排序的话，我们用long类型表示，
 *  一个long占用8个字节也就是64位，
 *  所以如果我们使用位图排序的话只会占用约0.125G内存,内存占用大大减少。
 *  但位图排序有个缺点就是数据不能有重复的，如果有重复的会覆盖掉，
 *  这也是位图能在海量数据中去重的原因，我们看下位图排序的代码
 * @Author: Scott S
 * @Date: 2018-12-06 9:34
 * @Version: 1.0
 */
public class WeiTu {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        int [] array2 = new  int[20];
        Random random = new Random();
        for(int i = 0; i < array2.length; i++){
            array2[i] = random.nextInt(1000) - 500;
        }
        System.out.println("排序前：" + Arrays.toString(array2));
        int temp2[] = bitmapSott2(array2);
        System.out.println("排序后：" + Arrays.toString(temp2));
    }

    private static int[] bitmapSort1(int[] array){
        int max = getMaxNumbit1(array);
        int N = max / 64 + 1;
        long[] bitmap = new long[N];
        for(int i = 0; i < array.length; i++){
            bitmap[array[i] / 64] |= 1L << (array[i] % 64);
        }
        int k =0;
        for(int i = 0; i< N; i++){
            for(int j = 0; j < 64; j++){
                if((bitmap[i] & (1L << j)) != 0){
                    array[k++] = i * 64 + j;
                }
            }
        }
        if(k < array.length){
            return Arrays.copyOfRange(array, 0, k);
        }
        return array;
    }

    private static int getMaxNumbit1(int array[]){
        int max = array[0];
        for(int i = 1, length = array.length; i < length; i ++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 我们看到这是使用的是位表示，一个long类型占8个字节，但他可以表示64个数字，
     * 所以内存占用会大大减少。最后有个k < array.length的判断，
     * 是因为如果有重复的数据会覆盖掉重复的，导致数组变小。
     * 但这里面还有个问题就是不能有负数出现，如果出现负数会报异常，
     * 我们也可以改一下让负数也可以排序，看代码。
     * @param array
     * @return
     */
    private static int[] bitmapSott2(int[] array){
        int[] value = getMaxNumbit2(array);
        int N = (value[0] - value[1]) + 1 / 64 + 1;
        long[] bitmap = new long[N];
        for(int i = 0; i < array.length; i++){
            bitmap[(array[i] - value[1]) / 64] |= 1L << ((array[i] - value[1]) & 64);
        }
        int k = 0;
        int[] temp = new int[array.length];
        for(int i= 0; i < N; i++){
            for(int j = 0; j < 64; j++){
                if((bitmap[i] & (1L << j)) != 0){
                    temp[k++] = i * 64 + j + value[1];
                }
            }
        }
        if(k < temp.length){
            return Arrays.copyOfRange(temp, 0, k);
        }
        return temp;
    }

    private static int[] getMaxNumbit2(int array[]){
        int max = array[0];
        int min = array[0];
        for(int i = 1, length = array.length; i < length; i++){
            if(array[i] > max){
                max = array[i];
            }else if(array[i] < min){
                min = array[i];
            }
        }
        return new int[]{max, min};
    }



}
