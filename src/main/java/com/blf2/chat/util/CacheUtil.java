package com.blf2.chat.util;

import com.github.benmanes.caffeine.cache.Cache;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class CacheUtil {

    @Resource(name = "caffeineCache")
    private Cache<String,String> caffeineCache;
    public void setCache(String key,String value){
        caffeineCache.put(key,value);
    }

    public String getValue(String key){
        return caffeineCache.getIfPresent(key);
    }

    public void removeKey(String key){
        caffeineCache.invalidate(key);
    }
}
