package com.catj.service;

import com.catj.service.hystrix.CasHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:UserService,v 0.1 2018/9/29 15:00 mc.han Exp $
 **/
@FeignClient(value = "catj-cas",fallback = CasHystrix.class)
public interface LoginService {


    @RequestMapping(value = "login", produces = { "application/json;charset=UTF-8" })
    String goLogin(String name);

}
