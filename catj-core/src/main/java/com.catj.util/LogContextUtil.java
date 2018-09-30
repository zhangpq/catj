package com.catj.util;

import org.slf4j.MDC;

/**
 * Created by Administrator on 2018/9/30.
 */
public class LogContextUtil {

    public static void setModule(String module){
        MDC.put("Module",module);
    }

    public static void setCategory(String category){
        MDC.put("Category",category);
    }

    public static void setFilterChain(String filter){
        MDC.put("FilterChain",filter);
    }

    public static void setContext(String module,String category,String filter){
        setModule(module);
        setCategory(category);
        setFilterChain(filter);
    }

    public static void clear(){
        MDC.clear();
    }

}
