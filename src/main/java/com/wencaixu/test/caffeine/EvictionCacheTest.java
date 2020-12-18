package com.wencaixu.test.caffeine;


import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

// Caffeine驱逐策略:基于大小，基于时间，基于权重
public class EvictionCacheTest {
    public static void main(String[] args) {
        // 根据缓存计数进行驱逐
        LoadingCache<String,String> number = Caffeine.newBuilder()
                .maximumSize(1000) // 指定缓存的最大容量
                .build(x->x+"_1");

        // 根据缓存权重来进行驱逐(权重大小用于确定缓存大小，不会用于决定缓存是否被驱逐)
        LoadingCache<String,String> weigth = Caffeine.newBuilder()
                .maximumWeight(1000)
                .weigher((String x, String y)-> y.length())
                .build(x->x+"_2");

        // 使用maximumSize




    }
}
