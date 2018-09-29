package com.catj.service.hystrix;

import com.catj.service.UserService;
import org.springframework.stereotype.Component;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:UserHystrix,v 0.1 2018/9/29 15:39 mc.han Exp $
 **/
@Component
public class UserHystrix  implements UserService{

    @Override
    public String testUser() {

        return "no";
    }
}
