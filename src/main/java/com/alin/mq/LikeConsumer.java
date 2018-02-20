package com.alin.mq;

import com.alin.model.Twitter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LikeConsumer {
    @Resource
    RedisTemplate redisTemplate;

    private static String KEY_LIKE = "com.alin.like.key";

    @JmsListener(destination = "com.alin.twitter.like")
    public void recevieQueue(Twitter twitter){
        redisTemplate.opsForSet().add(KEY_LIKE, twitter.getId());
        redisTemplate.opsForSet().add(twitter.getId(), twitter.getUserId());
    }
}

