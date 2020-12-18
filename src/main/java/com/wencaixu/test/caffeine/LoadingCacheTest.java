package com.wencaixu.test.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// 同步加载,使用CacheLoader构建缓存值，
public class LoadingCacheTest {

    public static void main(String[] args) {
        LoadingCache<String,String> loadingCache = Caffeine.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(key -> key+"_1");

        loadingCache.put("name","name");
        // 如果key不存在，则按照build中的Function进行处理
        String name = loadingCache.get("name");
        System.out.println(name);
        
        // 获取组key的值返回的一个Map
        List<String> keys = new ArrayList<>();
        keys.add("name");

        Map<String, String> all = loadingCache.getAll(keys);
        for(String key : all.keySet()){
            System.out.println(key + "->" + all.get(key));
        }
        //批量查找可以使用getAll方法。默认情况下，getAll将会对缓存中没有值的key分别调用CacheLoader.load方法来构建缓存的值。我们可以重写CacheLoader.loadAll方法来提高getAll的效率。
        //注意：您可以编写一个CacheLoader.loadAll来实现为特别请求的key加载值。例如，如果计算某个组中的任何键的值将为该组中的所有键提供值，则loadAll可能会同时加载该组的其余部分
    }
}
