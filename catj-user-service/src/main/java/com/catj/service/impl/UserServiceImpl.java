package com.catj.service.impl;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.catj.constant.ModuleEnum;
import com.catj.dao.UserDao;
import com.catj.model.User;
import com.catj.service.UserService;
import com.catj.util.LogContextUtil;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Security;
import java.util.Date;
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

    /**
     * 测试方法
     *
     * @return
     */
    public String testUser() {
        LogContextUtil.setUuidContext(ModuleEnum.USER_MODULE.getDesc(), "测试用户");
        logger.info("哈哈~~日志配置成功啦！");
        logger.error("测试失败啦！");
        LogContextUtil.clear();
        return "i am hqa,current port is : " + port + ",the foo is :" + foo;
    }

    /**
     * 查找登录用户
     *
     * @param userPhone
     * @param password
     * @return
     */
    @Override
    public User findLoginUser(String userPhone, String password) {
        LogContextUtil.setUuidContext(ModuleEnum.USER_MODULE.getDesc(), "查找登录用户");
        try {
            return userDao.findByUsernameAndUserPhone(userPhone, SecureUtil.md5(password));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查找登录用户异常,userPhone:".concat(userPhone), e);

        } finally {
            LogContextUtil.clear();
        }

        return null;
    }


}
