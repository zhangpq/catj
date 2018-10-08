package com.catj.constant;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:ModuleEnum,v 0.1 2018/10/8 11:20 mc.han Exp $
 **/
public enum ModuleEnum {

    USER_MODULE("用户模块"),
    CAS_MODULE("单点登录");


    private String desc;

    private ModuleEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
