package com.hyf.spring6.integration.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author baB_hyf
 * @date 2022/01/13
 */
@EnableCaching
@Configuration
public class CacheConfiguration {

    // 必须指定一个CacheManager
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    // 全局配置
    @Bean
    public CachingConfigurer cachingConfigurer() {
        return new CachingConfigurer() {
            @Override
            public CacheManager cacheManager() {
                return new ConcurrentMapCacheManager();
            }

            @Override
            public CacheResolver cacheResolver() {
                return new SimpleCacheResolver(cacheManager());
            }

            @Override
            public KeyGenerator keyGenerator() {
                return new SimpleKeyGenerator();
            }

            @Override
            public CacheErrorHandler errorHandler() {
                return new SimpleCacheErrorHandler();
            }
        };
    }
}
