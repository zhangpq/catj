package com.catj.service.hystrix;

import com.catj.service.LoginService;

/**
 * Created by Administrator on 2018/10/7.
 */
public class CasHystrix implements LoginService {
    @Override
    public String goLogin() {
        return "service fail!";
    }
}
