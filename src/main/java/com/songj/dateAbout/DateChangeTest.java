package com.songj.dateAbout;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
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

    @Test
    public void long_to_localDate(){
        long ll = 1623427200000L;
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(ll), ZoneId.systemDefault()).toLocalDate());
        System.out.println(LocalDate.ofEpochDay(ll));

    }


    /**
     * @Description: 格式化日期
     */
    @Test
    public void formatDate(){
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDateTime dateTime1 = LocalDateTime.of(2020, 2, 11, 13, 15, 12);
        String r = dateTime1.format(formatter1);
        TemporalAccessor parse1 = formatter1.parse(r);
        LocalDate from1 = LocalDate.from(parse1);
        System.out.println(from1);

        LocalDate currentDate = LocalDate.now();
        LocalDate date2 = LocalDate.of(2020, 12, 1);
        System.out.println(currentDate);
        System.out.println(date2);
        System.out.println(currentDate.isAfter(date2));

        LocalDateTime localDateTime=LocalDateTime.now();
        //格式化日期时间类型为字符串
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ss = dateTimeFormatter.format(localDateTime).toString();
        System.out.println(ss);
        //日期时间字符串类型转 LocalDateTime
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime yy = LocalDateTime.parse("2017-09-28 21:22:33", df);
        System.out.println(yy);
        //日期字符串转日期类型
        LocalDate localDate=LocalDate.parse("2019-12-10",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDate.toString());
        //带时区时间字符串转换标准字符串
        DateTimeFormatter dateTimeFormatter_ = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime strr = LocalDateTime.parse("2020-01-02T08:28:43.785",DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
        String time = dateTimeFormatter_.format(strr);
        System.out.println("格式化后标准时间:"+time);

    }

    @Test
    public void check(){
        String specifiedDateStr = "2020-10-11";
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM");
        Date currentDate = new Date();
        String currentDateStr = simpleFormat.format(currentDate);
        Date currentDateDormat = formatDate(currentDateStr, simpleFormat);
        Date date_202011 = formatDate("2020-11", simpleFormat);
        Date specifiedDate = formatDate(specifiedDateStr, simpleFormat);
        System.out.println(currentDateDormat);
        System.out.println(date_202011);
        System.out.println(specifiedDate);
        System.out.println(specifiedDate.compareTo(date_202011) != -1);
        System.out.println(specifiedDate.compareTo(currentDateDormat) != 1);
        //获取月的第一天和最后一天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(specifiedDate);
        calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY,0);//将小时至0
        calendar.set(Calendar.MINUTE,0);//将分钟至0
        calendar.set(Calendar.SECOND,0);//将秒至0
        Date specifiedFirstDate = calendar.getTime();
        System.out.println("specifiedFirstDate = " + specifiedFirstDate);
        calendar.add(Calendar.MONTH, 1);//n代表和本月偏移 0本月、1后一月，-1前一月
        calendar.add(Calendar.SECOND, -1);// 如果需要获取最后一天，则月份偏移后，在1号0时0分0秒基础上-1秒
        Date specifiedLastDate = calendar.getTime();
        System.out.println("specifiedLastDate = " + specifiedLastDate);
    }
    private Date formatDate(String date, SimpleDateFormat simpleFormat){
        Date paramYearMonth = null;
        try {
            paramYearMonth = simpleFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("日期格式化失败" + e.getMessage());
        }
        return  paramYearMonth;
    }


    /**
     * @Description: 定位某个时间：of方法
     */
    public void localTime(){
        LocalDateTime dateTime = LocalDateTime.of(2020, 2, 11, 13, 15, 12);
        LocalDate date = LocalDate.of(2020, 2, 11);

        LocalTime localTime =LocalTime.now();
        System.out.println("localTime" + localTime);

    }

    /**
     * @Description: 获取某月第一天，最后一天以及一共有多少天，以及当前月是第几月
     */
    public void getSpecifiedDay(){
        LocalDateTime dateTime = LocalDateTime.of(2020, 2, 11, 13, 15, 12);
        YearMonth month = YearMonth.from(dateTime);
        LocalDate begin = month.atDay(1);
        int length = month.lengthOfMonth();
        LocalDate end = month.atEndOfMonth();
        int monthValue = month.getMonthValue();
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
     * 获取时间是周几
     */
    @Test
    public void getWeekDay(){
        String[] WEEKS = {"周日","周一","周二","周三","周四","周五","周六","周日"};
        //周日
        LocalDate ld_7 = LocalDate.of(2021, 1, 10);
        DayOfWeek dayOfWeek_ld_7 = ld_7.getDayOfWeek();
        System.out.println(ld_7 + " : " + dayOfWeek_ld_7);
        System.out.println(ld_7 + " : " + dayOfWeek_ld_7.getValue());
        System.out.println(ld_7 + " : " + WEEKS[dayOfWeek_ld_7.getValue()]);
        //周一
        LocalDate ld_1 = LocalDate.of(2021, 1, 11);
        DayOfWeek dayOfWeek_ld_1 = ld_1.getDayOfWeek();
        System.out.println(ld_1 + " : " + dayOfWeek_ld_1);
        System.out.println(ld_1 + " : " + dayOfWeek_ld_1.getValue());
        System.out.println(ld_1 + " : " + WEEKS[dayOfWeek_ld_1.getValue()]);

        LocalDate now = LocalDate.now();
        DayOfWeek dayOfWeek_now = now.getDayOfWeek();
        System.out.println(now + " : " + dayOfWeek_now);
        System.out.println(now + " : " + dayOfWeek_now.getValue());
        System.out.println(now + " : " + WEEKS[dayOfWeek_now.getValue()]);
    }



    /**
     * @Description: 获取某个时间是否为闰年
     */
    public void isLeapYear(){
        LocalDateTime dateTime = LocalDateTime.of(2020, 2, 11, 13, 15, 12);
        boolean leapYear = dateTime.toLocalDate().isLeapYear();
        System.out.println(leapYear);
        boolean leap = Year.of(2016).isLeap();
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
     * @Description: 计算两个时间的差值（day，hour，minute等）
     */
    public void calculateTimeByLocalDateTime(){
        LocalDateTime dateTime1 = LocalDateTime.of(2020, 2, 11, 13, 15, 12);
        LocalDateTime dateTime2 = LocalDateTime.of(2020, 3, 11, 13, 15, 12);
        Duration between = Duration.between(dateTime1, dateTime2);
        System.out.println(between.toDays());
        System.out.println(between.toHours());
        System.out.println(between.toMinutes());
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

    //LocalDate -> Date
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    //LocalDateTime -> Date
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    //Date -> LocalDate
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    //Date -> LocalDateTime
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
