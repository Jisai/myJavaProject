package com.songj.threadAbout;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * @ClassNamee: Thread01
 * @Description: Java任务的并行处理
 * https://mp.weixin.qq.com/s?__biz=MzIwNDY1NTU1OA==&mid=2247483768&idx=1&sn=00512ee12024e3d30788a867ddad8d86&chksm=973d9fd1a04a16c7e7699fcf308365c3c66a1cdb812b80bfd2bdfbb5c6c3b5b6e83b36a19811&mpshare=1&scene=1&srcid=&sharer_sharetime=1581330973568&sharer_shareid=af38cc627e62b51d17a338d418274bbe&key=9c0a8c4c60b2594ec797e4e447849590f008ede8235b88334eaccd6605ef51b1b4fd3af8f5497486486fe9c8b1ab43c2df3c5d91e95d111e8015232b42c14d8b0af2a3e2df1f62410ac2227fb3f24d24&ascene=1&uin=NzU5MzY1NzYx&devicetype=Windows+10&version=62080074&lang=zh_CN&exportkey=AWSQeT5NLkagx5yEe8Nep%2F4%3D&pass_ticket=W3VwUug69aKWKTzVMmEcODe1UrMKQZhYGz3T5tcGelHhS4RU%2FAhuN3SyVjgcjp%2FA
 * @Author: Scott S
 * @Date: 2020-02-11 15:59
 * @Version: 1.0
 **/
public class Thread01 {

    public static final int THRESHOLD = 10_000;
    public static long[] numbers;
    private static long allSum;


    /**
     * @Description: 直接使用主线程进行求和操作
     * @param: []
     * @return: void
     * @auther: Scott S
     * @date: 2020/2/11 16:00
     */
    @Test
    public void sum01(){
        numbers = LongStream.rangeClosed(1, 10_000_000).toArray();
        long sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("sum  = " + sum);
    }

    /**
     * @Description: 指定了一个拆分阀值，计算拆分多少个任务，同时启动多少线程；
     * 这种处理就是启动的线程数过多，而CPU数有限，更重要的是求和是一个计算密集型任务，
     * 启动过多的线程只会带来更多的线程上下文切换；
     * 同时线程处理完一个任务就终止了，也是对资源的浪费；
     * 另外可以看到主线程不知道何时子任务已经处理完了，
     * 需要做额外的处理；所有Java后续引入了线程池。
     * @param: []
     * @return: void
     * @auther: Scott S
     * @date: 2020/2/12 16:42
     */
    @Test
    public void sum02() throws Exception {
        numbers = LongStream.rangeClosed(1, 10_000_000).toArray();
        int taskSize = (int) (numbers.length / THRESHOLD);
        for (int i = 1; i <= taskSize; i++) {
            final int key = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sumAll(sum((key - 1) * THRESHOLD, key * THRESHOLD));
                }
            }).start();
        }
        Thread.sleep(100);
        System.out.println("allSum = " + getAllSum());
    }

    private static synchronized long sumAll(long threadSum) {
        return allSum += threadSum;
    }

    public static synchronized long getAllSum() {
        return allSum;
    }

    private static long sum(int start, int end) {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }



}
