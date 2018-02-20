package com.alin.service;


import com.alin.model.Twitter;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<Twitter> findAll();

    boolean twitterLike(Long userId,Long twitterId);

}
