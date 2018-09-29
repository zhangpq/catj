package com.catj.util;

import java.util.Collection;
import java.util.Map;

/**
 * LY.com.Inc
 * Copyright (c) 2004-2018 ALL Rights Reserved
 *
 * @author mc.han
 * @version $Id:DataUtils,v 0.1 2018/9/29 11:15 mc.han Exp $
 **/
public class DataUtils {

    public static boolean isEmpty(Object o) {
        if(o == null)return true;
        if(o instanceof String){
            if ("".equals(((String)o).trim())) return true;
        }
        if(o instanceof Collection){
            if(((Collection)o).isEmpty())return true;
        }
        if(o instanceof Map){
            if(((Map)o).isEmpty())return true;
        }
        return false;
    }

}
