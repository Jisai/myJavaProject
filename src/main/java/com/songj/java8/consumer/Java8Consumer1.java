package com.songj.java8.consumer;

import java.util.function.Consumer;

/**
 * @ClassNamee: Java8Consumer1
 * @Description:
 * @Author: Scott S
 * @Date: 2022-02-24 20:41
 * @Version: 1.0
 **/
public class Java8Consumer1 {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = x -> System.out.println("hello!" + x);
        stringConsumer.accept("cattle");
    }
}
