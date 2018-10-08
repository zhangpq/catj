package com.catj.service;

import com.catj.service.hystrix.RedisHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:RedisService,v 0.1 2018/10/8 9:54 mc.han Exp $
 **/
@FeignClient(value = "midware-service",fallback = RedisHystrix.class)
public interface RedisService {

    @RequestMapping(value = "setValue", produces = { "application/json;charset=UTF-8" })
    void setValue(String key,String value);


    @RequestMapping(value = "setExpireValue", produces = { "application/json;charset=UTF-8" })
    void setExpireValue(String key,String value,Long expireTime);

    @RequestMapping(value = "exists", produces = { "application/json;charset=UTF-8" })
    boolean exists(String key);

    @RequestMapping(value = "get", produces = { "application/json;charset=UTF-8" })
    Object get(String key);

    @RequestMapping(value = "remove", produces = { "application/json;charset=UTF-8" })
    void remove(String key);

    @RequestMapping(value = "batchRemove", produces = { "application/json;charset=UTF-8" })
    void batchRemove(String... keys);

    @RequestMapping(value = "removePattern", produces = { "application/json;charset=UTF-8" })
    void removePattern(String pattern);


}
