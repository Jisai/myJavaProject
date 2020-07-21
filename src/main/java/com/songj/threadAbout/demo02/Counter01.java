package com.songj.threadAbout.demo02;

/**
 * @ClassName: Counter01
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2019/6/24 17:46
 * @Version: 1.0
 **/
public class Counter01 {

    private volatile int count = 0;

    public void inc() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
    @Override
    public String toString() {
        return "[count=" + count + "]";
    }

}
