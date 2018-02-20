package com.alin.service.impl;

import com.alin.dal.TwitterDal;
import com.alin.dal.UserTwitterLikeDal;
import com.alin.model.Twitter;
import com.alin.model.UserTwitterLike;
import com.alin.mq.LikeProducer;
import com.alin.service.TwitterService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.List;

@Service
public class TwitterServiceImpl implements TwitterService {
    private static Destination destination=new ActiveMQQueue("com.alin.twitter.like");

    @Autowired
    TwitterDal twitterDal;
    @Autowired
    UserTwitterLikeDal userTwitterLikeDal;


    @Resource
    LikeProducer likeProducer;

    @Resource
    RedisTemplate redisTemplate;

    @Override
    public List<Twitter> findAll() {
        List<Twitter> all = twitterDal.findAll();
        if (all == null) {
            //log
            return null;
        }
        return all;
    }

    @Override
    public boolean like(Long userId, Long twitterId) {
        if (userId == null || twitterId == null) {
            return false;
        }
        Twitter twitter = twitterDal.findById(twitterId);
        if (twitter == null) {
            //log
            return false;
        }

        int num = twitterDal.updateLikes(twitter.getLikes() + 1, twitterId);

        UserTwitterLike userTwitterLike = new UserTwitterLike();
        userTwitterLike.setUserId(userId);
        userTwitterLike.setTwitterId(twitterId);

        userTwitterLikeDal.insert(userTwitterLike);

        if (num != 0) {
            return true;
        }

        return false;
    }

    @Override
    public List<Twitter> findAllByCache() {
        List<Twitter> all = twitterDal.findAll();
        if (all == null) {
            //log
            return null;
        }

        for (Twitter t : all) {
            if (redisTemplate.opsForSet().members(t.getId()) != null) {
                t.setLikes(redisTemplate.opsForSet().size(t.getId()).intValue());
            } else {

            }
        }

        return all;
    }


    @Override
    public boolean likeByCache(Long userId, Long twitterId) {
        Twitter twitter=new Twitter();
        twitter.setId(twitterId);
        twitter.setUserId(userId);

        likeProducer.sendMessage(destination,twitter);


        return Boolean.TRUE;
    }

}
