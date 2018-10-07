package com.catj.service;

import com.catj.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/10/7.
 */
@RestController
public class RedisService {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("put")
    public String put(String key,String value){
        boolean ret = redisUtil.set(key, value);
        if(ret)return "ok the value is " + redisUtil.get(key);
        return "fail";
    }

}
