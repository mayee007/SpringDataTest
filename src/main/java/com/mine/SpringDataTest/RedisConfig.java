package com.mine.SpringDataTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@org.springframework.context.annotation.Configuration
@EnableRedisRepositories
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private int redisPort;
    
	@Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration 
        	= new RedisStandaloneConfiguration(redisHost, redisPort);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

	@Bean
	public RedisTemplate<Object, Object> redisTemplate() {
		  RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		  template.setConnectionFactory(connectionFactory());
		  return template; 
	}
    
    /* 
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
    	return redis Template; 
    }
    
    @Bean 
    public RedisTemplate<String, Problem> redisTemplateProblem() {
    	RedisTemplate<String, Problem> redisTemplate = new RedisTemplate<String, Problem>(); 
    	redisTemplate.setConnectionFactory(jedisConnectionFactory());
    	return redisTemplate; 
    }  */   
}