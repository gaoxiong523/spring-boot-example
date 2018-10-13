package com.gaoxiong.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * @author gaoxiong
 * @ClassName RedisConfig
 * @Description TODO
 * @date 2018/10/13 17:58
 */
@Configuration
public class RedisConfig {


 /*   @Bean
    public RedisTemplate redisTemplate( RedisConnectionFactory redisConnectionFactory ){
        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setKeySerializer(redisSerializer());
//        redisTemplate.setValueSerializer(redisSerializer());
        redisTemplate.setDefaultSerializer(redisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisSerializer<Employee> redisSerializer () {
       return new Jackson2JsonRedisSerializer<Employee>(Employee.class);
    }
*/

    /**
     * 自定义cacheManage
     * @param factory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory){
        //生成一个默认配置
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();

        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofMinutes(10))//设置缓存的过期时间
                .disableCachingNullValues()//不缓存空值
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(myRedisSerializer()));
        RedisCacheManager cacheManager = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(factory)
                .cacheDefaults(redisCacheConfiguration)
                .build();
        return cacheManager;
    }

    /**
     * jackson 的序列化器,需要另外配置objectmapper
     * @return
     */
    @Bean
    public RedisSerializer myRedisSerializer(){
        Jackson2JsonRedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        redisSerializer.setObjectMapper(objectMapper);
        return redisSerializer;
    }

}
