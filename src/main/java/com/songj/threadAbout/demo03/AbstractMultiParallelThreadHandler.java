package com.songj.threadAbout.demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassNamee: AbstractMultiParallelThreadHandler
 * @Description: 并行线程处理
 * @Author: Scott S
 * @Date: 2019-11-11 18:45
 * @Version: 1.0
 **/
public abstract class AbstractMultiParallelThreadHandler implements MultiThreadHandler{

    /**
     * 子线程倒计数锁
     */
    protected CountDownLatch childLatch;

    /**
     * 任务列表
     */
    protected List<Runnable> taskList;

    /**
     * 子线程异常
     */
    protected Exception childThreadException;

    public AbstractMultiParallelThreadHandler() {
        taskList = new ArrayList<Runnable>();
        childThreadException = new Exception();
    }

    public void setCountDownLatch(CountDownLatch latch) {
        this.childLatch = latch;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTask(Runnable... tasks) {
        if (null == tasks) {
            taskList = new ArrayList<Runnable>();
        }
        for (Runnable task : tasks) {
            taskList.add(task);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void run() throws Exception;
}
