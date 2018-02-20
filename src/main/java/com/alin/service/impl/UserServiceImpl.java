package com.alin.service.impl;

import com.alin.dal.UserDal;
import com.alin.model.Twitter;
import com.alin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<Twitter> findAll() {
        return null;
    }

    @Override
    public boolean twitterLike(Long userId, Long twitterId) {
        return false;
    }
}
