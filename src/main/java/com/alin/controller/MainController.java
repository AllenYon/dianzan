package com.alin.controller;


import com.alibaba.fastjson.JSON;
import com.alin.model.Twitter;
import com.alin.service.TwitterService;
import com.alin.service.UserService;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class MainController {

    @Resource
    UserService userSerivce;

    @Resource
    TwitterService twitterService;


    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(Object obj) {
        List<Twitter> all = twitterService.findAll();
        return JSON.toJSONString(all);
    }

    @RequestMapping("/like")
    public String like(@RequestParam(value = "twitterId") String twitterId,
                       @RequestParam(value = "userId") String userId) {

        return null;
    }
}
