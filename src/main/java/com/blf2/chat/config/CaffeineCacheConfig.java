package com.blf2.chat.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 用户token缓存 暂时先用单机的
 * 若是多实例部署 需要把这个换成或者JWT
 */
@Configuration
public class CaffeineCacheConfig {

    @Bean("caffeineCache")
    public Cache<String,String> caffeineCache(){
        return Caffeine.newBuilder()
                // 数量上限
                .maximumSize(1000)
                // 过期机制
                .expireAfterAccess(30, TimeUnit.MINUTES)
                .build();
    }
}
