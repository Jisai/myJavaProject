package com.songj.threadAbout.liKou.Topic_1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassNamee: Method_1
 * @Description:按序打印
 * 方法一：使用 synchronization
 *      首先初始化共享变量 firstJobDone 和 secondJobDone，初始值表示所有方法未执行。
 *      方法 first() 没有依赖关系，可以直接执行。在方法最后更新变量 firstJobDone 表示该方法执行完成。
 *      方法 second() 中，检查 firstJobDone 的状态。如果未更新则进入等待状态，否则执行方法 second()。
 *      在方法末尾，更新变量 secondJobDone 表示方法 second() 执行完成。
 *      方法 third() 中，检查 secondJobDone 的状态。与方法 second() 类似，执行 third() 之前，需要先等待 secondJobDone 的状态。
 **/
public class Method_1 {


    public static void main(String[] args) {

    }


    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Method_1() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }
}
