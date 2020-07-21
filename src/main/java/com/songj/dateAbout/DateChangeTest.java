package com.songj.dateAbout;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: dateChangeTest
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2018-07-03 11:21
 * @Version: 1.0
 */
public class DateChangeTest {

    @Test
    public void getYesterday(){
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        System.out.println(yesterday); ;
    }

    @Test
    public void transformStringToDate(){
        String dateString = "2019-10-10 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date = sdf.parse(dateString);
            System.out.println(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param dateTime
     * @param flag     开始时间：true 00:00:00 结束时间：false 23:59:59
     * @return String
     * @throws
     * @Title: longConvertTimeInit
     * @Description: 日期+时间初始化
     */
    public Long longConvertTimeInit(Long dateTime, Boolean flag) {
        Long time = 0L;
        String date = "";
        if (null == dateTime || dateTime.equals("")) {
            return time;
        }
        try {
            Date dt = new Date(dateTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            date = sdf.format(dt);
            if (flag) {
                String beginTime = " 00:00:00";
                date = date + beginTime;

            } else {
                String endTime = " 23:59:59";
                date = date + endTime;
            }
            SimpleDateFormat sdfDt = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            return sdfDt.parse(date).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return time;
        }
    }

    /****
     * 传入具体日期 ，返回具体日期增加一个月。
     * @param date 日期(2017-04-13)
     * @return 2017-05-13
     * @throws ParseException
     */
    private  String subMonth(String date) {
        String reStr = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.MONTH, 1);
            Date dt1 = rightNow.getTime();
            reStr = sdf.format(dt1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    /****
     * 传入具体日期 ，返回具体日期减少一天
     * @param date 日期(2017-04-13)
     * @return 2017-04-12
     * @throws ParseException
     */
    private  String subDay(String date){
        String reStr = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.DAY_OF_MONTH, -1);
            Date dt1 = rightNow.getTime();
            reStr = sdf.format(dt1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    /****
     * 传入具体日期 ，返回具体日期减少一天
     * @param dateLong
     * @return
     * @throws ParseException
     */
    private  Long subDay(Long dateLong){
        Long resLong = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

            Date ownDate = df.parse("2018-03-01 00:00:00");
            Date nowDate1 = ownDate;
//            Date nowDate1 = new Date();
            System.out.println("当前系统时间1：" + df.format(nowDate1));// new Date()为获取当前系统时间
            Long nowLong = nowDate1.getTime();
            Date nowDate2 = new Date(nowLong);
            System.out.println("当前系统时间2：" + df.format(nowDate2));// new Date()为获取当前系统时间

            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(nowDate2);
            rightNow.add(Calendar.DAY_OF_MONTH, -1);
            Date dt1 = rightNow.getTime();

            System.out.println("当前系统时间3：" + df.format(dt1));// new Date()为获取当前系统时间

            resLong = dt1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long currentTime = System.currentTimeMillis();
        System.out.println(currentTime + " || " + resLong);
        return resLong;
    }

    public Date getDesigDate(){
        Date result = new Date();
        LocalDateTime localDateTime = LocalDateTime.of(2000, Month.JANUARY,1,0,0,0);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        result = Date.from(instant);
        System.out.println(result);
        return result;
    }



    /**
     * @Description: 判断是有是有效时间
     * @param: [param]
     * @return: boolean
     * @auther: Scott S
     * @date: 2019/11/8 18:57
     */
    @Test
    public void isEffectiveDate(){
        Date param = new Date();
        boolean result = false;
        String begin = "2000-01-21 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(begin);
            result = param.after(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


    /**
     * 用SimpleDateFormat计算时间差
     * @throws ParseException
     */
    @Test
    public void calculateTimeDifferenceBySimpleDateFormat() throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        /*天数差*/
        Date fromDate1 = simpleFormat.parse("2018-03-22 12:00");
        Date toDate1 = simpleFormat.parse("2018-03-01 12:00");
        long from1 = fromDate1.getTime();
        long to1 = toDate1.getTime();
        int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));
        System.out.println("两个时间之间的天数差为：" + days);

        /*小时差*/
        Date fromDate2 = simpleFormat.parse("2018-03-01 12:00");
        Date toDate2 = simpleFormat.parse("2018-03-12 12:00");
        long from2 = fromDate2.getTime();
        long to2 = toDate2.getTime();
        int hours = (int) ((to2 - from2) / (1000 * 60 * 60));
        System.out.println("两个时间之间的小时差为：" + hours);

        /*分钟差*/
        Date fromDate3 = simpleFormat.parse("2018-03-01 12:00");
        Date toDate3 = simpleFormat.parse("2018-03-12 12:00");
        long from3 = fromDate3.getTime();
        long to3 = toDate3.getTime();
        int minutes = (int) ((to3 - from3) / (1000 * 60));
        System.out.println("两个时间之间的分钟差为：" + minutes);
    }

    @Test
    public void compare() throws ParseException{
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date1 = simpleFormat.parse("2018-03-12 12:00");
        Date date2 = new Date();
        System.out.println(date1.after(date2));
        System.out.println(date1.after(date1));
    }

}
