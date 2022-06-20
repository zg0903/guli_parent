package com.atguigu.commonutils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.commonutils
 * @date 2022-06-20-22:01
 * @Desc:
 */

@Component
public class ConstantWxUtils implements InitializingBean {

    @Value("${wx.open.app_id}")
    private String appId;


    @Value("${wx.open.app_secret}")
    private String appScret;


    @Value("${wx.open.redirect_url}")
    private String redirectUrl;


    public static String WX_OPEN_APP_ID;
    public static String WX_OPEN_APP_SECRET;
    public static String WX_OPEN_REDIRECT_URL;


    @Override
    public void afterPropertiesSet() throws Exception {
        WX_OPEN_APP_ID = appId;
        WX_OPEN_APP_SECRET = appScret;
        WX_OPEN_REDIRECT_URL = redirectUrl;

    }
}
