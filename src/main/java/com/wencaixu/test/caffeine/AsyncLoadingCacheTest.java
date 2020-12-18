package com.wencaixu.test.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步加载
 */
public class AsyncLoadingCacheTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncLoadingCache<String,String> asyncLoadingCache = Caffeine.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .buildAsync(key->key + "_1");

        // 如果name不存在，则按照key->key+"_1"进行生成值
        CompletableFuture<String> graph = asyncLoadingCache.get("name");

        System.out.println(graph.get());

        List<String> keys = new ArrayList<>();
        keys.add("name");
        CompletableFuture<Map<String, String>> all = asyncLoadingCache.getAll(keys);
        Map<String, String> stringStringMap = all.get();
        //异步转同步
        asyncLoadingCache.synchronous();

        // AsyncLoadingCache是继承自LoadingCache类的，异步加载使用Executor去调用方法并返回一个CompletableFuture。异步加载缓存使用了响应式编程模型。
        // 如果要以同步方式调用时，应提供CacheLoader。要以异步表示时，应该提供一个AsyncCacheLoader，并返回一个CompletableFuture。
        // synchronous()这个方法返回了一个LoadingCacheView视图，LoadingCacheView也继承自LoadingCache。调用该方法后就相当于你将一个异步加载的缓存AsyncLoadingCache转换成了一个同步加载的缓存LoadingCache。
        //默认使用ForkJoinPool.commonPool()来执行异步线程，但是我们可以通过Caffeine.executor(Executor) 方法来替换线程池。
    }

}
