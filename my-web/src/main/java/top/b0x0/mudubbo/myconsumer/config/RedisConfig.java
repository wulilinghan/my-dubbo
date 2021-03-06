//package top.b0x0.mudubbo.myconsumer.config;
//
//import com.alibaba.fastjson.parser.ParserConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cache.Cache;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.interceptor.CacheErrorHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * redis config
// *
// * @author TANG
// * @since 2020-11-27
// */
//@Slf4j
//@Configuration
//@ConditionalOnClass(RedisOperations.class)
//@EnableConfigurationProperties(RedisProperties.class)
//public class RedisConfig extends CachingConfigurerSupport {
//
//    @Bean(name = "redisTemplate")
//    @ConditionalOnMissingBean(name = "redisTemplate")
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        RedisSerializer<?> stringSerializer = new StringRedisSerializer();
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    @Bean(name = "objectRedisTemplate")
//    @ConditionalOnMissingBean(name = "objectRedisTemplate")
//    public RedisTemplate<Object, Object> objectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        // value?????????????????????fastJsonRedisSerializer
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        // ????????????AutoType?????????????????????????????????????????????
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        // ???????????????????????????????????????????????????
//        // ParserConfig.getGlobalInstance().addAccept("me.zhengjie.domain");
//        // key??????????????????StringRedisSerializer
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        return template;
//    }
//
//
//    /**
//     * redis???????????????????????? ??????????????????????????????????????????????????????????????????
//     * ??????redis????????????????????????????????????????????????????????????????????????????????????????????????????????????
//     */
//    @Bean
//    @Override
//    public CacheErrorHandler errorHandler() {
//        // ??????????????????Redis??????????????????????????????????????????????????????
//        log.info("????????? -> [{}]", "Redis CacheErrorHandler");
//        return new CacheErrorHandler() {
//
//            @Override
//            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
//                log.error("Redis occur handleCacheGetError???key -> [{}]", key, e);
//            }
//
//            @Override
//            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
//                log.error("Redis occur handleCachePutError???key -> [{}]???value -> [{}]", key, value, e);
//            }
//
//            @Override
//            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
//                log.error("Redis occur handleCacheEvictError???key -> [{}]", key, e);
//            }
//
//            @Override
//            public void handleCacheClearError(RuntimeException e, Cache cache) {
//                log.error("Redis occur handleCacheClearError???", e);
//            }
//        };
//    }
//
//}
//
//
