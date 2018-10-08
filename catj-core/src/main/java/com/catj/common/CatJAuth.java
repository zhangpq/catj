package com.catj.common;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:CatJAuth,v 0.1 2018/10/8 16:32 mc.han Exp $
 **/
public class CatJAuth {

    private String authToken;

    public CatJAuth(String authToken){
        this.authToken = authToken;
    }

    public static CatJAuth createAuth(String authToken){

        return new CatJAuth(authToken);
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
