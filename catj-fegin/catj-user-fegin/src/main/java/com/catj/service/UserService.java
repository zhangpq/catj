package com.catj.service;

import com.catj.model.User;
import com.catj.service.hystrix.UserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:UserService,v 0.1 2018/9/29 15:00 mc.han Exp $
 **/
@FeignClient(value = "user-service",fallback = UserHystrix.class)
public interface UserService {

    @RequestMapping(value = "test", produces = { "application/json;charset=UTF-8" })
    String testUser();

    @RequestMapping(value = "findLoginUser", produces = { "application/json;charset=UTF-8" })
    User findLoginUser(@RequestParam("userPhone") String userPhone,@RequestParam("password") String password);

}
