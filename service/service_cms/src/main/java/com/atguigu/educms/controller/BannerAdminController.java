package com.atguigu.educms.controller;


import com.atguigu.commonutils.R;
import com.atguigu.educms.entity.CrmBanner;
import com.atguigu.educms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-06-07
 */
@RestController
@CrossOrigin
@RequestMapping("/educms/banneradmin")
public class BannerAdminController {

    @Autowired
    private CrmBannerService BannerService;

    //    1 分页查询
    @GetMapping("pageBanner/{page}/{limit}")
    public R pageBanner(@PathVariable long page, @PathVariable long limit) {
        Page<CrmBanner> pageBanner = new Page<>(page, limit);
        BannerService.page(pageBanner, null);
        return R.ok().data("item", pageBanner.getRecords()).data("total", pageBanner.getTotal());
    }

    //    2添加banner
    @PostMapping("addBanner")
    public R addBanner(@RequestBody CrmBanner crmBanner) {
        BannerService.save(crmBanner);
        return R.ok();
    }


    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        CrmBanner banner = BannerService.getById(id);
        return R.ok().data("item", banner);
    }

    @PutMapping("update")
    public R updateById(@RequestBody CrmBanner crmBanner) {
        BannerService.updateById(crmBanner);
        return R.ok();
    }


    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        BannerService.removeById(id);
        return R.ok();
    }

}

