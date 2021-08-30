package com.songj.oddNumbers;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassNamee: OrderNumberUtil
 * @Description: 获取订单号
 * @Author: Scott S
 * @Date: 2020-09-08 16:52
 * @Version: 1.0
 **/
public class OrderNumberUtil {

    /**  https://mp.weixin.qq.com/s/MKYM9cCCFH6DlFGQ7sjh2w
     测试结果：
     生成订单数：8000
     过滤重复后订单数：8000
     重复订单数：0
     **/
    @Test
    public void testGenerateOrderNo(){
        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        IntStream.range(0,8000).parallel().forEach(i->{
            orderNos.add(generateOrderNo());
        });

        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());

        System.out.println("生成订单数："+orderNos.size());
        System.out.println("过滤重复后订单数："+filterOrderNos.size());
        System.out.println("重复订单数："+(orderNos.size()-filterOrderNos.size()));
    }

    @Test
    public void testGenerateOrderNo2(){
        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        IntStream.range(0,8000).parallel().forEach(i->{
            orderNos.add(generateOrderNo());
        });

        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());

        System.out.println("订单样例："+ orderNos.get(22));
        System.out.println("生成订单数："+orderNos.size());
        System.out.println("过滤重复后订单数："+filterOrderNos.size());
        System.out.println("重复订单数："+(orderNos.size()-filterOrderNos.size()));
    }



    //使用线程安全的计数器做数字递增(三位数最低保证并发800不重复,代码中我给了4位)
    private static final AtomicInteger SEQ = new AtomicInteger(1000);
    //毫秒仅保留三位(缩减长度同时保证应用切换不存在重复的可能)
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");
    //日期转换为java8的日期类以格式化(线程安全及代码简洁性考量)
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");

    /**
     * generateOrderNo()方法内不需要加锁，因为AtomicInteger内使用的是CAS自旋转锁(保证可见性的同时也保证原子性,具体的请自行了解)
     */
    public static String generateOrderNo(){
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if(SEQ.intValue()>9990){
            SEQ.getAndSet(1000);
        }
        return  dataTime.format(DF_FMT_PREFIX)+SEQ.getAndIncrement();
    }


    private volatile static String IP_SUFFIX = null;
    /**
     * getLocalIpSuffix()方法内不需要对不为null的逻辑加同步锁(双向校验锁，整体是一种安全的单例模式)
     */
    private static String getLocalIpSuffix (){
        if(null != IP_SUFFIX){
            return IP_SUFFIX;
        }
        try {
            synchronized (OrderNumberUtil.class){
                if(null != IP_SUFFIX){
                    return IP_SUFFIX;
                }
                InetAddress addr = InetAddress.getLocalHost();
                //  172.17.0.4  172.17.0.199 ,
                String hostAddress = addr.getHostAddress();
                if (null != hostAddress && hostAddress.length() > 4) {
                    String ipSuffix = hostAddress.trim().split("\\.")[3];
                    if (ipSuffix.length() == 2) {
                        IP_SUFFIX = ipSuffix;
                        return IP_SUFFIX;
                    }
                    ipSuffix = "0" + ipSuffix;
                    IP_SUFFIX = ipSuffix.substring(ipSuffix.length() - 2);
                    return IP_SUFFIX;
                }
                IP_SUFFIX = RandomUtils.nextInt(10, 20) + "";
                return IP_SUFFIX;
            }
        }catch (Exception e){
            System.out.println("获取IP失败:"+e.getMessage());
            IP_SUFFIX =  RandomUtils.nextInt(10,20)+"";
            return IP_SUFFIX;
        }
    }


}
