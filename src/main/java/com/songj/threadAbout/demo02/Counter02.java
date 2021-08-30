package com.songj.threadAbout.demo02;

/**
 * @ClassName: Counter02
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2019/6/24 17:46
 * @Version: 1.0
 **/
public class Counter02 {

    public static int count = 0;

    public synchronized void inc() {
        count++;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                // n=count+1改成了inc()
                inc();
                // 为了使运行结果更随即，延迟3毫秒
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "[count=" + count + "]";
    }
}