package com.zhaol.common.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * redis 相关配置
 *
 * @version 1.0
 * @author: 赵力
 * @创建时间:2020/12/4 9:52
 */
@Configuration
public class RedisConfig {
    /**
     * 过期时间1天
    */
    private final Duration timeToLive = Duration.ofDays(1);

    /**
     * redisTemplate模板提供给其他类对redis数据库进行操作
     * @param connectionFactory
     * @return org.springframework.data.redis.cache.RedisCacheManager
     * @author 赵力
     * @date 2020-12-04 09:55:14
    */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        // 设置 CacheManger
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                //redis缓存配置
                .entryTtl(this.timeToLive)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
                .disableCachingNullValues();
        //根据redis缓存配置和reid连接工厂生成redis缓存管理器
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .transactionAware()
                .build();
        return redisCacheManager;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(keySerializer());
        redisTemplate.setHashKeySerializer(keySerializer());
        redisTemplate.setValueSerializer(valueSerializer());
        redisTemplate.setHashValueSerializer(valueSerializer());
        return redisTemplate;
    }

    /**
     * redis键序列化使用StringRedisSerializer
     * @param
     * @return org.springframework.data.redis.serializer.RedisSerializer<java.lang.String>
     * @author 赵力
     * @date 2020-12-04 09:56:12
    */
    private RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    /**
     * redis值序列化使用json序列化器
     * @param
     * @return org.springframework.data.redis.serializer.RedisSerializer<java.lang.Object>
     * @author 赵力
     * @date 2020-12-04 09:56:36
    */
    private RedisSerializer<Object> valueSerializer() {
        // 采用Alibaba的序列化器
        return new GenericFastJsonRedisSerializer();
    }

}
