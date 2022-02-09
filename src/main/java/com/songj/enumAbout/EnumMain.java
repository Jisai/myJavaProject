package com.songj.enumAbout;

public class EnumMain {


    public static void main(String[] args) {
        //十进制 转 二进制
        System.out.println( Integer.toBinaryString(2));
        System.out.println( Integer.toBinaryString(0));
        System.out.println( Integer.toBinaryString(-1));
        //二进制 转 十进制
        String n1 = "0001";
        String n2 = "0011";
        System.out.println(Integer.parseInt(n1,2));
        System.out.println(Integer.parseUnsignedInt(n2,2));
        //1234
        //2
        String t2 = "0010";
        //2，3
        String t3 = "0110";
        //3，4
        String t4 = "1100";

        System.out.println(Integer.parseUnsignedInt(t4,2) & Integer.parseUnsignedInt("0011",2));

    }
}
