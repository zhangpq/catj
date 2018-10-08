package com.catj.service;

import com.catj.common.CatJResult;
import com.catj.service.hystrix.LoginHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:UserService,v 0.1 2018/9/29 15:00 mc.han Exp $
 **/
@FeignClient(value = "catj-cas",fallback = LoginHystrix.class)
public interface LoginService {


    /**
     * 去登录
     * @param userPhone
     * @param password
     * @return
     */
    @RequestMapping(value = "goLogin", produces = { "application/json;charset=UTF-8" })
    CatJResult goLogin(String userPhone, String password);

    /**
     * 退出登录
     * @param authToken
     * @return
     */
    @RequestMapping(value = "logout", produces = { "application/json;charset=UTF-8" })
    CatJResult logout(String authToken);

}
