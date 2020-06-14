package com.mine.SpringDataTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.mine.SpringDataTest.Model.*;
@Configuration
@ComponentScan("com.model")
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private int redisPort;
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHost);
        redisStandaloneConfiguration.setPort(redisPort);
        redisStandaloneConfiguration.setDatabase(0);
        
        JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());

        return jedisConFactory;
    }

    @Bean 
    public RedisTemplate<String, Technology> redisTemplateTechnology() {
    	RedisTemplate<String, Technology> redisTemplate = new RedisTemplate<String, Technology>(); 
    	redisTemplate.setConnectionFactory(jedisConnectionFactory());
    	return redisTemplate; 
    }

    @Bean 
    public RedisTemplate<String, Info> redisTemplateInfo() {
    	RedisTemplate<String, Info> redisTemplate = new RedisTemplate<String, Info>(); 
    	redisTemplate.setConnectionFactory(jedisConnectionFactory());
    	return redisTemplate; 
    }
    
    @Bean 
    public RedisTemplate<String, Problem> redisTemplateProblem() {
    	RedisTemplate<String, Problem> redisTemplate = new RedisTemplate<String, Problem>(); 
    	redisTemplate.setConnectionFactory(jedisConnectionFactory());
    	return redisTemplate; 
    }    
}