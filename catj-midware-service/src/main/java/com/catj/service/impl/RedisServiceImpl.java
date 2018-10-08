package com.catj.service.impl;

import com.catj.service.RedisService;
import com.catj.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:RedisServiceImpl,v 0.1 2018/10/8 9:49 mc.han Exp $
 **/
@RestController
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisUtil redisUtil;

    private Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    private static final String REDIS_ERROR = "REDIS_ERROR";


    @Override
    public void setValue(String key, String value) {
        try{
            redisUtil.set(key,value);
        }catch (Exception e){
            logger.error(REDIS_ERROR,e);
            e.printStackTrace();
        }

    }

    @Override
    public void setExpireValue(String key, String value, Long expireTime) {
        try{
            redisUtil.set(key,value,expireTime);
        }catch (Exception e){
            logger.error(REDIS_ERROR,e);
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(String key) {
        try{
            return redisUtil.exists(key);
        }catch (Exception e){
            logger.error(REDIS_ERROR,e);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object get(String key) {
        try{
            return redisUtil.get(key);
        }catch (Exception e){
            logger.error(REDIS_ERROR,e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(String key) {
        try{
            redisUtil.remove(key);
        }catch (Exception e){
            logger.error(REDIS_ERROR,e);
            e.printStackTrace();
        }
    }

    @Override
    public void batchRemove(String... keys) {
        try{
            redisUtil.remove(keys);
        }catch (Exception e){
            logger.error(REDIS_ERROR,e);
            e.printStackTrace();
        }
    }

    @Override
    public void removePattern(String pattern) {
        try{
            redisUtil.removePattern(pattern);
        }catch (Exception e){
            logger.error(REDIS_ERROR,e);
            e.printStackTrace();
        }
    }
}
