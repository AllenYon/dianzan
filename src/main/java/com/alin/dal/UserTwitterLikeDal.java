package com.alin.dal;

import com.alin.model.User;
import com.alin.model.UserTwitterLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTwitterLikeDal {

    /**
     * 插入用户-推 喜欢关系
     *
     * @return
     */
    void insert(UserTwitterLike userTwitterLike);

}
