package com.alin.service;


import com.alin.model.Twitter;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TwitterService {

    List<Twitter> findAll();

    boolean like(Long userId, Long twitterId);


    List<Twitter> findAllByCache();

    boolean likeByCache(Long userId, Long twitterId);
}
