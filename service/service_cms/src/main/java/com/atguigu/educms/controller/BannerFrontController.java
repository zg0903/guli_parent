package com.atguigu.educms.controller;

import com.atguigu.commonutils.R;
import com.atguigu.educms.entity.CrmBanner;
import com.atguigu.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.educms.controller
 * @date 2022-06-08-21:42
 * @Desc:
 */


@RestController
@CrossOrigin
@RequestMapping("/educms/bannerFront")
public class BannerFrontController {

    @Autowired
    private CrmBannerService bannerService;


    //    查询所有bannner
    @GetMapping("getAllBanner")
    public R getAllBanner() {
        List<CrmBanner> list = bannerService.selectAllBanner();
        return R.ok().data("list", list);

    }


}
