package com.catj.service.hystrix;

import com.catj.common.CatJResult;
import com.catj.service.LoginService;

/**
 * Created by Administrator on 2018/10/7.
 */
public class LoginHystrix implements LoginService {

    @Override
    public CatJResult goLogin(String userPhone, String password) {
        return null;
    }
}
