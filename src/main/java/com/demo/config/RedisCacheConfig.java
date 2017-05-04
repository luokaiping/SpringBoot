package com.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by lWX458933 on 2017/5/2.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName(env.getProperty("spring.redis.host"));
        redisConnectionFactory.setPort(Integer.parseInt(env.getProperty("spring.redis.port")));
        redisConnectionFactory.setTimeout(Integer.parseInt(env.getProperty("spring.redis.timeout")));
        return redisConnectionFactory;
    }

    /**
     * 缓存管理器
     * @param redisTemplate
     * @return cacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate){
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return  cacheManager;
    }

    /**
     * Redis模板操作
     * @param redisConnectionFactory
     * @return redisTemplate
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    public CacheErrorHandler errorHandler() {
        return new CacheErrorHandler(){

            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
                log.warn("handleCacheGetError in redis: {}", exception.getMessage());
            }

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
                log.warn("handleCachePutError in redis: {}", exception.getMessage());
            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
                log.warn("handleCacheEvictError in redis: {}", exception.getMessage());
            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {
                log.warn("handleCacheClearError in redis: {}", exception.getMessage());
            }};
    }
}
