package com.example.redis.config;

import lombok.Getter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.crypto.KeyGenerator;
import java.lang.reflect.Method;

@Configuration
@EnableCaching
@Getter
public class RedisCacheConfig {

    private volatile LettuceConnectionFactory lettuceConnectionFactory;
    private volatile RedisTemplate<String, String> redisTemplate;
    private volatile RedisCacheManager redisCacheManager;

    public RedisCacheConfig(){
        super();
    }

    /*
      带参数的构造方法 初始化所有成员变量
     */
    public RedisCacheConfig(LettuceConnectionFactory lettuceConnectionFactory, RedisTemplate<String, String> redisTemplate, RedisCacheManager redisCacheManager){
        this.lettuceConnectionFactory = lettuceConnectionFactory;
        this.redisTemplate = redisTemplate;
        this.redisCacheManager = redisCacheManager;
    }

    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            //规定  本类名-方法名-参数名 为key(这个是没有自己指定key的时候，自己默认生成的)
            @Override
            public Object generate(Object o, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append("-");
                sb.append(method.getName());
                sb.append("-");
                for (Object param : params) {
                    sb.append(param.toString());
                }
                return sb.toString();
            }
        };
    }
}
