package com.example.service01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.Collections;

@Configuration
public class CacheConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10))) // Default TTL for all caches
                .withInitialCacheConfigurations(Collections.singletonMap("partnerProducts", // Specific cache
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))) // TTL for 'partnerProducts' cache
                .build();
    }
}