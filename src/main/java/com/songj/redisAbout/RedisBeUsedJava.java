package com.songj.redisAbout;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: RedisBeUsedJava
 * @Description: java 使用 redis
 * @Author: Scott S
 * @Date: 2018-06-14 11:13
 * @Version: 1.0
 */
public class RedisBeUsedJava {

    public static void main(String[] args) {
        RedisBeUsedJava thisObj = new RedisBeUsedJava();
        thisObj.test04();
    }

    /**
     * 测试连接本地redis服务
     */
    public void  test01(){
        //连接本地 Redis 服务。
        Jedis jedis = new Jedis("localhost");
        System.out.println("redis 连接成功！");
        //查看服务是否运行
        System.out.println("redis服务正在运行：" + jedis.ping());
    }

    /**
     * 设置 字符串 数据并获取
     */
    public void  test02(){
        //连接本地 Redis 服务。
        Jedis jedis = new Jedis("localhost");
        System.out.println("redis 连接成功！");
       //设置rdis字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        jedis.set("runoobkey", "www.runoob.com1");
        jedis.set("runoobkey", "www.runoob.com2");
        //获取存储的数据并输出
        System.out.println("redis 存储的字符串为：" + jedis.get("runoobkey"));
    }

    /**
     * 存储数据到列表中，并取出
     */
    public void test03(){
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("redis 连接成功！");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        //获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0,2);
        for (String one : list){
            System.out.println("列表项为：" + one);
        }
    }

    /**
     * redis java key 实例
     */
    public void test04(){
        Jedis jedis = new Jedis("localhost");
        System.out.println("redis 连接成功！");
        //获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator it = keys.iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            System.out.println(key);
        }
    }

}
