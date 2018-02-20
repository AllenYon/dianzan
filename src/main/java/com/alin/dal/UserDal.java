package com.alin.dal;

import com.alin.model.User;

import java.util.List;

public interface UserDal {

    List<User> findAll();
}
