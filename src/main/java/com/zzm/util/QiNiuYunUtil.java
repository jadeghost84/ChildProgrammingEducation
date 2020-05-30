package com.zzm.util;


import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;


public class QiNiuYunUtil {

    private static String accessKey = "BUVFY7Cab1B1pvI6S8-BoDwOzOhnboMqShmfonuT";

    private static String secretKey = "lDnpBVNbnqfj9yBs2rL30VLA7hjrzVaDtvcIw5qb";

    private static String bucket = "childeducation";

    private static String areaName = "http://ss.xznkzt.top/";

    public static String getToken(){

        Auth auth = Auth.create(accessKey,secretKey);
        String token = auth.uploadToken(bucket);
        return token;
    }

    public static String getAreaName(){
        return areaName;
    }
}
