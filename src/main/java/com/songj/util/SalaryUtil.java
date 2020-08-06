package com.songj.util;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassNamee: SalaryUtil
 * @Description: 薪资计算工具
 * @Author: Scott S
 * @Date: 2020-08-05 10:28
 * @Version: 1.0
 **/
public class SalaryUtil {


    //计算补缴五险一金
    @Test
    public void  calculateTheFiveSocialInsuranceAndOneHousingFund(){
        //保留小数位数
        int scale = 4;
        //缴纳基数
        BigDecimal paymentBase = new BigDecimal(6000);
        //养老
        BigDecimal pension = new BigDecimal(480);
        //医疗
        BigDecimal medicalTreatment = new BigDecimal(123);
        //公积金
        BigDecimal providentFund = new BigDecimal(720);
        //薪资
        BigDecimal salary = new BigDecimal(17000);
        //开始日期
        String startDate = "2018-11-13";
        //结束日期
        String endDate = "2020-08-01";
        //月份数
        int numberOfMonths = getMonthDiff(startDate, endDate) ;
        System.out.println("月份数为：" + numberOfMonths + "个月。");
        //养老金比例
        BigDecimal pensionRatio = pension.divide(paymentBase,scale, BigDecimal.ROUND_HALF_UP);
        System.out.println("缴纳养老金比例：" + pensionRatio);
        //医疗
        BigDecimal medicalTreatmentRatio = medicalTreatment.divide(paymentBase,scale, BigDecimal.ROUND_HALF_UP);
        System.out.println("缴纳医疗比例：" + medicalTreatmentRatio);
        //公积金
        BigDecimal providentFundRatio = providentFund.divide(paymentBase,scale, BigDecimal.ROUND_HALF_UP);
        System.out.println("缴纳公积金比例：" + providentFundRatio);
        //补充缴纳基数
        BigDecimal paymentBaseMakeUp = salary.subtract(paymentBase);
        //应补养老金
        BigDecimal pensionMakeUp = paymentBaseMakeUp.multiply(pensionRatio).setScale(scale, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(numberOfMonths));
        System.out.println("应补养老金：" + pensionMakeUp);
        //应补医疗
        BigDecimal medicalTreatmentMakeUp = paymentBaseMakeUp.multiply(medicalTreatmentRatio).setScale(scale, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(numberOfMonths));
        System.out.println("应补医疗：" + medicalTreatmentMakeUp);
        //应补公积金
        BigDecimal providentFundMakeUp = paymentBaseMakeUp.multiply(providentFundRatio).setScale(scale, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(numberOfMonths));
        System.out.println("应补公积金：" + providentFundMakeUp);
        //累计应补金额
        BigDecimal sumMakeUp = pensionMakeUp.add(medicalTreatmentMakeUp).add(providentFundMakeUp);
        System.out.println("累计应补金额：" + sumMakeUp);
    }



    @Test
    public void bb(){
        System.out.println(getMonthDiff("2012-02-14", "2012-03-01"));
        System.out.println(getMonthDiff("2012-02-14", "2012-03-13"));
        System.out.println(getMonthDiff("2012-02-14", "2012-03-14"));
        System.out.println(getMonthDiff("2012-02-14", "2012-03-15"));
        System.out.println(getMonthDiff("2012-02-01", "2012-03-31"));
    }

    /**
     * 获取两个日期相差的月数
     * @param d2  较大的日期
     * @param d1  较小的日期
     * @return 如果d1>d2返回 月数差 否则返回0
     */
    public static int getMonthDiff(String d1, String d2){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        //将String日期转换成date
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date1= null;
        Date date2= null;
        try {
            date1 = sdf.parse(d1);
            date2 = sdf.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c1.setTime(date1);
        c2.setTime(date2);

        //判断两个日期的大小
        if(c2.getTimeInMillis() < c1.getTimeInMillis()){ return 0;}
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-9-30   d2 = 2015-12-16
        int yearInterval = year2 - year1;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month2 < month1 || month1 == month2 && day2 < day1){ yearInterval --;}
        // 获取月数差值
        int monthInterval = (month2 + 12) - month1 ;
        if(day2 > day1){ monthInterval ++;}
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;
    }






}
