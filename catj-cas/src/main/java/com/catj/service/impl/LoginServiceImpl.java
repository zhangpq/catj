package com.catj.service.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/6.
 */
@RestController
@RequestMapping("login")
public class LoginServiceImpl {

    @RequestMapping("goLogin")
    public String login(String name){

        return "my username is " + name;
    }

}
