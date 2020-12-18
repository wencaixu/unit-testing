package com.wencaixu.test.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * 手动加载
 */
// Caffine使用Window TinyLFA回收策略，提供一个近乎最佳的命中率
public class ManualCache {

    // Caffine缓存的填充策略：手动，同步和异步
    public static void main(String[] args) {
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();

        // 获取key，如果不存在则返回空
        String name = cache.getIfPresent("name");
        // 获取key,如果为空，按照function的值返回，并设置cache
        // 如果调用Function方法，返回为Null值的话，将抛出异常
        String age = cache.get("age",key->key+"_1");
        // 此处返回null age_1
        System.out.println(name+" "+age);
        // 添加缓存,会覆盖以前的值
        cache.put("name","name_1");
        cache.put("name","name_2");
        System.out.println(cache.getIfPresent("name"));
        // 删除缓存
        cache.invalidate("name");

        ConcurrentMap<String, String> stringStringConcurrentMap = cache.asMap();
        for(String key : stringStringConcurrentMap.keySet()){
            // 此处打印age->age_1 因为name已经过期
            System.out.println(key + "->" + stringStringConcurrentMap.get(key));
        }
    }

}
