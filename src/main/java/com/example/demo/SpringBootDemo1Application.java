package com.example.demo;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import com.example.demo.redis.messageDeque.Receiver;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@MapperScan("com.example.demo.mapper") // 将项目中对应的mapper类的路径加进来就可以了
public class SpringBootDemo1Application {
   public static void main(String[] args) {
   SpringApplication.run(SpringBootDemo1Application.class, args);
   }

//  private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootDemo1Application.class);
//
//  @Bean
//  RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//      MessageListenerAdapter listenerAdapter) {
//
//    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//    container.setConnectionFactory(connectionFactory);
//    container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
//
//    return container;
//  }
//
//  @Bean
//  MessageListenerAdapter listenerAdapter(Receiver receiver) {
//    return new MessageListenerAdapter(receiver, "receiveMessage");
//  }
//
//  @Bean
//  Receiver receiver(CountDownLatch latch) {
//    return new Receiver(latch);
//  }
//
//  @Bean
//  CountDownLatch latch() {
//    return new CountDownLatch(1);
//  }
//
//  @Bean
//  StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
//    return new StringRedisTemplate(connectionFactory);
//  }
//
//  public static void main(String[] args) throws Exception {
//    ApplicationContext ctx = SpringApplication.run(SpringBootDemo1Application.class, args);
//
//    StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//    CountDownLatch latch = ctx.getBean(CountDownLatch.class);
//
//    LOGGER.info("Sending message...");
//    template.convertAndSend("chat", "Hello from Redis!");
//
//    latch.await();
//
//    System.exit(0);
//  }


  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }

    };
  }
}
