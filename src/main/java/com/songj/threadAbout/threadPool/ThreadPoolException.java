package com.songj.threadAbout.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadPoolException
 * @BelongPackage: com.songj.threadAbout.ThreadPool
 * @Description: ThreadPoolExcutor 线程池 异常处理
 * 参考： https://www.cnblogs.com/wang-meng/p/10588637.html
 * @Author: Jisai
 * @Date: 2021/1/19 下午5:05
 * @Version: v1.0
 */
public class ThreadPoolException {
    private final static Logger LOGGER = LoggerFactory.getLogger(ThreadPoolException.class);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService execute = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        execute.execute(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("=====11=======");
            }
        });

        TimeUnit.SECONDS.sleep(5);
        execute.execute(new Run1());
    }


    private static class Run1 implements Runnable {
        @Override
        public void run() {
            int count = 0;
            while (true) {
                count++;
                LOGGER.info("-------222-------------{}", count);

                if (count == 10) {
                    System.out.println(1 / 0);
                    try {
                    } catch (Exception e) {
                        LOGGER.error("Exception",e);
                    }
                }

                if (count == 20) {
                    LOGGER.info("count={}", count);
                    break;
                }
            }
        }
    }
}
