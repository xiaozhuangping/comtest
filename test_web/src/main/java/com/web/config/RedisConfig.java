package com.web.config;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
 
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
/*@Configuration
@PropertySource(value = "classpath:/application.properties")
@EnableCaching*/
public class RedisConfig extends CachingConfigurerSupport {
    // @Value("${spring.redis.host}")
	// private String host;
	// @Value("${spring.redis.port}")
	// private int port;
	// @Value("${spring.redis.timeout}")
	// private int timeout;
	private static final Logger LOG = LoggerFactory.getLogger(RedisConfig.class);
 
	@Value("${spring.redis.host}")
	private String host;
 
	@Value("${spring.redis.port}")
	private int port;
 
	@Value("${spring.redis.timeout}")
	private int timeout;
 
	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;
 
	@Value("${spring.redis.pool.max-wait}")
	private long maxWaitMillis;

 
	/*
	 * @Value("${spring.redis.password}") private String password;
	 */
 
	// Jedis单个实例连接池
	@Bean
	public JedisPool redisPoolFactory() {
		LOG.info("JedisPool注入成功！！");
		LOG.info("redis地址：" + host + ":" + port);
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
		return jedisPool;
	}
	
	// JedisCluster集群链接池
	@Bean
	public JedisCluster JedisClusterFactory() {
		LOG.info("JedisCluster创建！！");
		LOG.info("redis地址：" + host + ":" + port);
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisClusterNodes.add(new HostAndPort(host, port));
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, jedisPoolConfig);
		return jedisCluster;
	}
 
	@Bean
	public KeyGenerator wiselyKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}
 
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(host);
		factory.setPort(port);
		factory.setTimeout(timeout); // 设置连接超时时间
		return factory;
	}
 
	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(10); // 设置key-value超时时间
		return cacheManager;
	}
 
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		setSerializer(template); // 设置序列化工具，这样ReportBean不需要实现Serializable接口
		template.afterPropertiesSet();
		return template;
	}
 
	private void setSerializer(StringRedisTemplate template) {
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
	}
}