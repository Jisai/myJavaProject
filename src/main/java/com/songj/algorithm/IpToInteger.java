package com.songj.algorithm;

/**
 * @ClassNamee: IpToInteger
 * @Description: 将ip地址与数字进行相互转换
 * @Author: Scott S
 * @Date: 2020-11-14 22:40
 * @Version: 1.0
 **/
public class IpToInteger {

    public static void main(String[] args) {
        System.out.println(ipToLong("219.239.110.138"));
        System.out.println(longToIP(18537472));
    }

    /**
     * @Description: 将ip地址转成long数值
     * 将IP地址转化成整数的方法如下：
     * ① 通过String的split方法按.分隔得到4个长度的数组；
     * ② 通过左移位操作（<<）给每一段的数字加权，
     *          第一段的权为2的24次方，
     *          第二段的权为2的16次方，
     *          第三段的权为2的8次方，
     *          最后一段的权为1。
     */
    public static Long ipToLong(String ipStr){
        String[] ipArr = ipStr.split("\\.");
        return (Long.parseLong(ipArr[0]) << 24)
                + (Long.parseLong(ipArr[1]) << 16)
                + (Long.parseLong(ipArr[2]) << 8)
                + Long.parseLong(ipArr[3]);
    }

    
    /**
     * @Description: 将数值转换为ip地址
     * 将十进制整数形式转换成127.0.0.1形式的ip地址
     * 将整数形式的IP地址转化成字符串的方法如下：
     * ① 将整数值进行右移位操作（>>>），右移24位，右移时高位补0，得到的数字即为第一段IP。
     * ② 通过与操作符（&）将整数值的高8位设为0，再右移16位，得到的数字即为第二段IP。
     * ③ 通过与操作符吧整数值的高16位设为0，再右移8位，得到的数字即为第三段IP。
     * ④ 通过与操作符吧整数值的高24位设为0，得到的数字即为第四段IP。
     */
    public static String longToIP(long longIp) {
        StringBuffer sb = new StringBuffer("");
        // 直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        // 将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        // 将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        // 将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }



}

