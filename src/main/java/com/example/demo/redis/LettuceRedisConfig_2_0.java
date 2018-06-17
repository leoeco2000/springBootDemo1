package com.example.demo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class LettuceRedisConfig_2_0 {

  @Bean
  LettuceConnectionFactory lettuceConnectionFactory() {
    LettuceConnectionFactory factory = new LettuceConnectionFactory();
      return factory;
  }

}
