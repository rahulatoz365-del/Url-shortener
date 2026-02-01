package org.url_shortener_spring.backend.config;

import com.github.ben-manes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("short_urls"); // Name of the cache
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // Remove items from cache 10 minutes after they are created
                .expireAfterWrite(10, TimeUnit.MINUTES)
                // Limit to 10,000 URLs in memory to prevent crashing the server
                .maximumSize(10_000));
        return cacheManager;
    }
}
