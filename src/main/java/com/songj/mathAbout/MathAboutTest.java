package com.songj.mathAbout;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: MathAboutTest  数字
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2018-07-18 9:43
 * @Version: 1.0
 */
public class MathAboutTest {

    @Test
    public void method01(){
        int i = 2;
        int y = 5;
        Float res = y/(float)i;

        System.out.println(res);//输出结果：3.3333333
        System.out.println("===== a =====");
        System.out.println(Math.floor(res));//输出结果：3.0
        Double resDouble = Math.ceil(res);
        System.out.println("====== b ====");
        System.out.println(resDouble);//输出结果：4.0
        System.out.println(resDouble.intValue());//输出结果：4
        System.out.println("===== c =====");
        System.out.println(y % i);
        System.out.println(Math.floorMod(y, i));
        System.out.println(y/ i);


    }


    /**
     * @Description: 求商四舍五入保留2位小数
     * @param: [v1, v2]
     * @return: java.math.BigDecimal
     * @auther: Scott S
     * @date: 2019/10/30 11:38
     */
    @Test
    public void divideROUND_HALF_UP (){
        Long v1 = 1L;
        Long v2 = 3L;
        int scale = 2; //小数点之后保留的小数
        boolean isAfter = false; //是否是百分比之后的数值
        if(v1 == null || v2 == null || v1.longValue() < 0 || v2.longValue() <= 0){
            System.out.println(-1);
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        if(isAfter){

            System.out.println( (b1.divide(b2, scale + 2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).setScale(scale, BigDecimal.ROUND_HALF_UP));
        }else {
            System.out.println(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP));
        }
    }


    @Test
    public void method02(){
        Integer a = 1;
        Long b = 1L;
        BigDecimal c = new BigDecimal(1);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println( "== " + String.class.toString());
    }

    /**
     * @Description: 获取取指定范围的随机数
     */
    @Test
    public void getRandomTimeOut(){
        int max = 100;
        int min = 90;
        Random random = new Random();
        for(int i= 0; i < 10; i++){
            int s = random.nextInt(max) % (max - min + 1) + min;
            System.out.println(s);
        }
    }



    @Test
    public void method03(){
        InnerObject innerObject = new InnerObject();
        innerObject.setNowTime(System.currentTimeMillis());

        System.out.println(innerObject.getNowTime());
    }

    @Test
    public void method04(){
        Integer obj_1 = 1;
        Integer obj_2 = 2;
        Integer obj_3 = 3;
        System.out.println(obj_1.compareTo(obj_2));
    }


    /**
     * @Description: 计算数组中的数字与目标数最接近的数
     * @Param: []
     * @Return: void
     * @Author: Scott S
     * @Date: 2019/5/30 - 15:52
     **/
    @Test
    public void method05(){
        //从小到大
        List<Double> list = Arrays.asList(0.500, 0.5625, 0.7500);
        double targetNum = 0.75;
        int leftIndex = 0;
        int rightIndex = list.size() -1;
        int resultIndex = 0;

        while (leftIndex < rightIndex){
            int midIndex = (leftIndex + rightIndex) >> 1;
            double a = list.get(midIndex);
            int b = compareDouble(targetNum, list.get(midIndex));
            if(compareDouble(targetNum, list.get(midIndex)) == 0){
                //注意先判断等于情况。等于，结束判断。
                resultIndex = midIndex;
                break;
            }else if(compareDouble(targetNum, list.get(midIndex)) == 1){
                //大于
                leftIndex = midIndex;

            }else if(compareDouble(targetNum, list.get(midIndex)) == -1){
                //小于
                rightIndex = midIndex;
            }
            if((rightIndex - leftIndex) <= 1){
                resultIndex = Math.abs(list.get(leftIndex) - targetNum) <=  Math.abs(list.get(rightIndex) - targetNum) ? leftIndex : rightIndex;
                break;
            }
        }
        System.out.println("与目标数值" + targetNum + "最接近的数值为：" + list.get(resultIndex) + " ；所在集合下标是：" + resultIndex);

    }


    /**
     *  i++ 先赋值在运算,例如 sum=i++,先赋值sum=i,后运算i=i+1,所以结果是sum==0
     * 	++i 先运算在赋值,例如 a=++i,先运算i=i+1,后赋值sum=i,所以结果是sum==1
     */
    @Test
    public void method06(){
        int i = 0;
        int sum = 0;
        sum = i++;
        System.out.println("i = " + i + "  sum = " + sum);
        i = 0;
        sum = 0;
        sum = ++i;
        System.out.println("i = " + i + "  sum = " + sum);
        i = 0;
        sum = 0;
        while (i < 5){
            sum = + i;
            i++;
        }
        System.out.println("i = " + i + "  sum = " + sum);
    }

    @Test
    public void method07(){


    }

    private int compareDouble(double a, double b){
        BigDecimal A = new BigDecimal(a);
        BigDecimal B = new BigDecimal(b);
        int result = A.compareTo(B);
        return result;
    }

    class InnerObject{
       private Long nowTime;

        public Long getNowTime() {
            return nowTime;
        }

        public void setNowTime(Long nowTime) {
            this.nowTime = nowTime;
        }
    }

}
