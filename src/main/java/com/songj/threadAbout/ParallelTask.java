package com.songj.threadAbout;


import java.util.*;
import java.util.function.Consumer;
/**
 * @ClassNamee: ParallelTask
 * @Description: java多线程并发任务执行
 * @Author: Scott S
 * @Date: 2019-11-07 10:57
 * @Version: 1.0
 **/

public class ParallelTask {

    private static int listcount = 0;
    private static Vector datas = new Vector();

    public class RunThread extends Thread {
        Consumer task, fianltask;

        public RunThread(String name, Consumer task, Consumer ftask) {
            super(name);
            this.task = task;
            this.fianltask = ftask;
        }

        @Override
        public void interrupt() {
            super.interrupt();
            synchronized (this) {
                listcount--;
                if (listcount == 0) {
                    // 我是最后一个了，那么，好吧
                    fianltask.accept(null);
                }
            }
        }

        @Override
        public void run() {
            while (!datas.isEmpty()) {
                HashMap<String, Object> data = (HashMap) datas.remove(0);
                System.out.println("线程" + getName() + " 开始处理新数据 " + data.get("id"));
                if (task != null) task.accept(data);
                System.out.println("线程" + getName() + " 处理数据完成 " + data.get("id"));
            }
            synchronized (this) {
                listcount--;
                if (listcount == 0) {
                    // 我是最后一个了，那么，好吧
                    fianltask.accept(null);
                }
            }
        }
    }

    void runTask(Consumer task, Consumer finaltask, List datas, int maxThreads) {
        ParallelTask.listcount = maxThreads;
        this.datas.addAll(datas);
        for (int i = 0; i < maxThreads; i++) {
            new RunThread(String.valueOf(i), task, finaltask).start();
        }
    }

    public static void main(String[] args) throws Exception {
        ParallelTask pt = new ParallelTask();

        ArrayList<Object> datas = new ArrayList();
        for (int i = 1; i < 33; i++) {
            HashMap<String, Object> d = new HashMap<>();
            d.put("id", "task_" + i);
            d.put("data", i * 3);
            datas.add(d);
        }

        pt.runTask(o -> {
//            try {
                System.out.println("do...... " + ((HashMap) o).get("data"));
//                Thread.sleep(Math.round(Math.random() * 60 + 5) * 100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }, o -> {
            System.out.println("全部工作完成了，欢迎下次再来！！！");
        }, datas, 10);
    }
}
