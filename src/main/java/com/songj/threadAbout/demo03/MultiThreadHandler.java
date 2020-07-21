package com.songj.threadAbout.demo03;

/**
 * @ClassNamee: MultiThreadHandler
 * @Description: 多任务处理
 * @Author: Scott S
 * @Date: 2019-11-11 18:42
 * @Version: 1.0
 **/
public interface MultiThreadHandler {

    /**
     * 添加任务
     * @param tasks
     */
    void addTask(Runnable... tasks);
    /**
     * 执行任务
     * @throws Exception
     */
    void run() throws Exception;

}
