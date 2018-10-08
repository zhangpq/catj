package com.catj.service.hystrix;

import com.catj.service.RedisService;
import org.springframework.stereotype.Component;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:RedisHystrix,v 0.1 2018/10/8 9:55 mc.han Exp $
 **/
@Component
public class RedisHystrix implements RedisService{

    @Override
    public void setValue(String key, String value) {

    }

    @Override
    public void setExpireValue(String key, String value, Long expireTime) {

    }

    @Override
    public boolean exists(String key) {
        return false;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void batchRemove(String... keys) {

    }

    @Override
    public void removePattern(String pattern) {

    }
}
