package com.example.demo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * redis配置
 * 
 */
//@Configuration
//@PropertySource(value = "classpath:/application.properties")
public class JedisRedisConfig_2_0 {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        return factory;
    }
}