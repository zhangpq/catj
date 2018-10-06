package com.catj.service.impl;

import com.catj.service.LoginService;
import com.catj.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/10/6.
 */
@RestController
public class LoginServiceImpl implements LoginService{

    @Resource
    private UserService userService;

    public String goLogin(String name){

        String result = userService.testUser();

        return "my username is " + name + ",the result is [" + result + "]";
    }

}
