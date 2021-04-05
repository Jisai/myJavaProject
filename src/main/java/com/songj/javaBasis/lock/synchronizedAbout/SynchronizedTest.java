package com.songj.javaBasis.lock.synchronizedAbout;

public class SynchronizedTest {

    //共享资源(临界资源)
    static int i=0;


    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }



}
