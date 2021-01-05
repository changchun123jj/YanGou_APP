package com.example.demo.config;


import com.example.demo.util.UtilLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:properties/redis.properties")
public class RedisConfig {
    UtilLog logger = UtilLog.getInstance(this);

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.block-when-exhausted}")
    private boolean blockWhenExhausted;


    public int getDatabase() {
        return database;
    }


    public void setDatabase(int database) {
        this.database = database;
    }


    @Bean
    public JedisPool redisPoolFactory() throws Exception {
        logger.info("JedisPool注入开始！");
        logger.info("redis地址：" + host + ":" + port);

        JedisPool jedisPool =null;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        if (null != password || !"".equals(password)) {
            jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        }else{
            jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        }

        logger.info("JedisPool注入成功！！");
        return jedisPool;
    }

}
