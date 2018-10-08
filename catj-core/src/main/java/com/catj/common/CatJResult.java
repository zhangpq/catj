package com.catj.common;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 * 统一返回体
 * @author mc.han
 * @version $Id:CatJResult,v 0.1 2018/10/8 10:32 mc.han Exp $
 **/
public class CatJResult {

    private Boolean flag;

    private String info;

    private String code;//200为成功

    private Object data;

    private final static String SUCCESS_CODE = "200";

    public CatJResult(Boolean flag, String info, String code, Object data) {
        this.flag = flag;
        this.info = info;
        this.code = code;
        this.data = data;
    }

    public static CatJResult buildResponse(Boolean flag, String info, String code, Object data){

        return new CatJResult(flag,info,code,data);
    }


    /**
     * 成功 1
     * @param info
     * @param data
     * @return
     */
    public static CatJResult OK(String info,Object data){

        return new CatJResult(true,info,SUCCESS_CODE,data);
    }

    /**
     * 成功 2
     * @param info
     * @return
     */
    public static CatJResult OK(String info){

        return new CatJResult(true,info,SUCCESS_CODE,null);
    }

    /**
     * 失败 1
     * @param info
     * @return
     */
    public static CatJResult FAIL(String info,String code){

        return new CatJResult(false,info,code,null);
    }


    /**
     * 失败 2
     * @param info
     * @return
     */
    public static CatJResult FAIL(String info,String code,Object data){

        return new CatJResult(false,info,code,data);
    }

    /**
     * 失败 3
     * @param info
     * @return
     */
    public static CatJResult FAIL(String info,Object data){

        return new CatJResult(false,info,null,data);
    }



}
