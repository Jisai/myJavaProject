package com.songj.threadAbout.threadPool.getresult;

import com.alibaba.fastjson.JSON;
import com.songj.threadAbout.threadPool.demo1.CheckTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassNamee: GetThreadResult01
 * @Description:  获取返回值
 * @Author: Scott S
 * @Date: 2020-07-08 21:36
 * @Version: 1.0
 **/
public class GetThreadResult01 {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10,
                1000, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        //该线程用于对线程池进行检测
        new Thread(new CheckTask(executor)).start();
        GetThreadResult01 getThreadResult01 = new GetThreadResult01();
        //运算数据准备
        Map<String, Long> param = new HashMap<>();
        for (long i = 0; i < 10L; i++) {
            param.put("参数-" + i, i);
        }
        List<String> result = getThreadResult01.test01(executor, param);
        System.out.println("任务执行完毕，结果集大小是：" + result.size() + "\n 详情为：" + JSON.toJSONString(result));
    }

    //业务方法
    public List<String> bussinessMethod(Map<String, Long> param){
        List<String> result = new ArrayList<>();
        if (param != null && param.keySet().size() > 0) {
            for (Map.Entry<String, Long> entry : param.entrySet()) {
                try {
                    //模拟执行耗时
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public List<String> test01(ThreadPoolExecutor executor, Map<String, Long> param){
        List<String> result = new ArrayList<>();
        //返回值
        List<String> list = new ArrayList<>();
        //线程操作
//        Future<List<String>> future = executor.submit(new Callable<List<String>>(){
//              @Override
//              public List<String> call() throws Exception {
//                  bussinessMethod(param, list);
//                  return list;
//              }
//          }
//        );
//        try {
//            result = future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


        Future<List<String>> future2 = null;
       for(int i =1; i<=4; i++){
           Callable callable =  new Callable<List<String>>(){
               @Override
               public List<String> call() throws Exception {
                   List<String>  list = bussinessMethod(param);
                   return list;
               }
           };
           future2 = executor.submit(callable);
           try {
               List<String> threadResult = future2.get();
               System.out.println("线程-"+i+" size >> " + threadResult.size() + "\n result >> " + JSON.toJSONString(threadResult));
               result.addAll(threadResult);
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
       }

        System.out.println("test01.result size >> " + result.size() + "\n result >> " + JSON.toJSONString(result));
        executor.shutdown();
        return result;
    }

}
