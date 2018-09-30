package com.catj.service.impl;

import com.catj.dao.UserDao;
import com.catj.model.User;
import com.catj.service.UserService;
import com.catj.util.LogContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

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

    @Value("${foo}")
    private String foo;

    @Resource
    private UserDao userDao;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public String testUser(){
        LogContextUtil.setContext("用户模块","测试用户", UUID.randomUUID().toString());
        logger.info("哈哈~~日志配置成功啦！");
        logger.error("测试失败啦！");
        LogContextUtil.clear();
        return "i am hqa,current port is : " + port + ",the foo is :" + foo;
    }

    @RequestMapping("addUser")
    public User addUser(){
        User user = new User();
        user.setAge(12);
        user.setName("zk");
        userDao.save(user);
        return user;
    }

}
