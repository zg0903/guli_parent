package com.atguigu.educenter.controller;

import com.atguigu.commonutils.ConstantWxUtils;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.educenter.controller
 * @date 2022-06-20-22:11
 * @Desc:
 */

@CrossOrigin
@Api("微信支付模板")
@Controller
@RequestMapping("/api/ucenter/wx")
public class WxApiController {


    //    1. 生成微信扫描二维码
    @GetMapping("login")
    public String getWxCode() {


        // 微信开放平台授权baseUrl  %s相当于?代表占位符
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        //对redirect_url进行URLEncoder编码
        String redirectUrl = ConstantWxUtils.WX_OPEN_REDIRECT_URL;
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "utf-8");
        } catch (Exception e) {
        }

        //设置%s里面值
        String url = String.format(
                baseUrl,
                ConstantWxUtils.WX_OPEN_APP_ID,
                redirectUrl,
                "atguigu"
        );

        //重定向到请求微信地址里面
//        https://open.weixin.qq.com/connect/qrconnect?appid=wxed9954c01bb89b47&redirect_uri=http%3A%2F%2Fguli.shop%2Fapi%2Fucenter%2Fwx%2Fcallback&response_type=code&scope=snsapi_login&state=atguigu#wechat_redirect
        return "redirect:" + url;

    }


}
