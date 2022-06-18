package com.atguigu.educenter.controller;


import com.atguigu.commonutils.R;
import com.atguigu.educenter.entity.UcenterMember;
import com.atguigu.educenter.entity.vo.RegisterVo;
import com.atguigu.educenter.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-06-15
 */

@RestController
@CrossOrigin
@RequestMapping("/educenter/member")
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    //    登陆
    @GetMapping("login")
    public R loginUser(@RequestBody UcenterMember member) {
//        返回token值 使用jwt生成
        String token = memberService.lgoin(member);

        return R.ok().data("token", token);

    }

    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo) {
        memberService.register(registerVo);
        return R.ok();
    }

}

