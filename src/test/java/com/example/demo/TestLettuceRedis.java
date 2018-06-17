package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestLettuceRedis {

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Test
  public void set() {
    redisTemplate.opsForValue().set("test:set", "testValue1");
  }
}
