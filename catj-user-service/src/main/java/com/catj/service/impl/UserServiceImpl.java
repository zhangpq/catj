package com.catj.service.impl;

import com.catj.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:UserServiceImpl,v 0.1 2018/9/29 11:40 mc.han Exp $
 **/
@RestController
public class UserServiceImpl implements UserService {
    @Value("${server.port}")

    private String port;

    public String testUser(){

        return "i am hqa,current port is : " + port;
    }

}
