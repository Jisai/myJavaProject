package com.songj.cache.localCache;

import com.alibaba.fastjson.JSON;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassNamee: CaffeineCacheTest
 * @Description:
 * @Author: Scott S
 * @Date: 2020-02-07 22:22
 * @Version: 1.0
 **/
public class CaffeineCacheTest {

    // 手动加载
    @Test
    public void test1() throws Exception {
        Cache<String, Object> manualCache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .build();
        String key = "test1";
        Object oj = new Object();
        // 根据key查询一个缓存，如果没有则调用createTestValue方法将返回值写到缓存
        // 如果createTestValue方法返回空，则get方法返回空
        // 如果createTestValue方法抛出异常，则get方法返回异常
//        manualCache.get(key, k -> createTestValue1(k));
//        System.out.println("oj = " + oj);
        // 将一个值写入缓存，如果存在就会覆盖掉已经存在的值
        manualCache.put(key, "i am test1 value1.");
        oj = manualCache.getIfPresent(key);
        System.out.println("oj = " + oj);
        // 删除一个缓存
        manualCache.invalidate(key);
        oj = manualCache.getIfPresent(key);
        System.out.println("oj = " + oj);
    }


    private static Object createTestValue1(String k) {

        return "i am createTestValue1 value.";
    }


    //同步加载
    @Test
    public void test2(){
        LoadingCache<String, Object> loadingCache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .build(key -> createTestValue2(key));
        String key = "test2";
        // 在获取指定key的值的时候
        // 如果没有获取到则通过在构建同步缓存的时候调用createTestValue方法写入方法值
        Object oj = loadingCache.get(key);
        System.out.println("oj : " + oj);

        loadingCache.put(key, "i am test2 value2");
        oj = loadingCache.getIfPresent(key);
        System.out.println("oj = " + oj);

    }
    private static Object createTestValue2(String k) { 		return "i am createTestValue2 value."; 	}


    //异步加载
    @Test
    public void test3(){
        AsyncLoadingCache<String, Object> asyncLoadingCache = Caffeine.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .buildAsync(key -> createTestValue3(key));
        String key = "test3";
        // 查询并且在指定的key不存在的时候，通过异步的方式来构建缓存，返回的是CompletableFuture
        CompletableFuture<Object> futrueOj = asyncLoadingCache.get(key);

        CompletableFuture<Object> obj = asyncLoadingCache.get(key);
        System.out.println("obj= " + JSON.toJSONString(obj));
    }
    private static Object createTestValue3(String k) { 		return "i am createTestValue3 value."; 	}
}
