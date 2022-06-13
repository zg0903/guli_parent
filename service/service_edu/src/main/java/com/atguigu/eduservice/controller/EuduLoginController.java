package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.controller
 * @date 2022-03-26-13:33
 * @Desc:
 */

@Api("登录")
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EuduLoginController {

    @PostMapping("login")
    public R logoin() {


        return R.ok().data("token", "admin");
    }

    //
    @GetMapping("info")
    public R info() {

        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://i.postimg.cc/05JdSVSk/adb34bf40ad162d93a1f27661edfa9ec8b13cd17.jpg");

    }


}
