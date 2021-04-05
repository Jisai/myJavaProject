package com.songj.threadAbout.threadPool.demo1;

import java.util.concurrent.Callable;

/**
 * @ClassNamee: MyCallable01
 * @Description: 自定义MyCallable接口任务
 * @Author: Scott S
 * @Date: 2020-07-15 18:44
 * @Version: 1.0
 **/
public class MyCallable01  implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("计算任务正在执行。。。");
        int summ=0;
        for(int i=1;i<=100;i++){
            Thread.sleep(100);
            summ ++;
        }
        System.out.println("计算任务结束");
        Integer result=new Integer(summ);
        return result;
    }
}
