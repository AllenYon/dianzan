package com.alin.dal;

import com.alin.model.Twitter;
import com.alin.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TwitterDal {

    /**
     * 查询所有推
     *
     * @return
     */
    List<Twitter> findAll();


    /**
     * 推的喜欢加1
     *
     * @return
     */
    Integer updateLikes(@Param("likeNum") int likeNum, @Param("id") Long id);

    Twitter findById(@Param("id") Long twitterId);

}
