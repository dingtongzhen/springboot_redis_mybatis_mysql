package com.dingzhen;

import com.dingzhen.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
@Slf4j
@SpringBootApplication
@MapperScan("com.dingzhen.mapper")//整合MyBatis，当前案例采用xml的方式
@EnableCaching // 开启缓存
@EnableTransactionManagement // 开启事务，保证redis与mysql中数据的一致性
public class SpringbootMybatisMysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisMysqlApplication.class, args);

    }

    // 使用Redis缓存采用Jackson进行序列化与反序列化是实体类不需要实现java.io.Serializable接口

    // 不使用springboot默认采用JDK进行序列化的操作，通过以下配置修改为基于Jackson的序列化操作
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        //加载redis缓存的默认配置
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return configuration;
    }

}
