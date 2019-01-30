package com.atguigu.springcloud.config;

import com.atguigu.springcloud.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class Redisconfig {
    @Bean
    public RedisTemplate<Object, Person> perRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Person> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Person.class);
        template.setDefaultSerializer(redisSerializer);
        return template;
    }
}
