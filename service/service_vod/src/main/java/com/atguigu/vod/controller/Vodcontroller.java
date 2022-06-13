package com.atguigu.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.atguigu.commonutils.R;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.ConstantVodUtils;
import com.atguigu.vod.utils.InitVodClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.vod.controller
 * @date 2022-05-15-15:41
 * @Desc:
 */

@CrossOrigin
@Api("阿里云视频点播")
@RestController
@RequestMapping("/eduvod/video")
public class Vodcontroller {
    @Autowired
    private VodService vodService;

    //    上传视频到阿里云  post
    @PostMapping("uploadAlyVide")
    public R uploadAlyVide(MultipartFile file) {

        String videId = vodService.uploadVideAly(file);
        return R.ok().data("videoId", videId);
    }


    @DeleteMapping("removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable String id) {
//        vodService

        try {
//            初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
//            插件删除视频requese对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(id);
            client.getAcsResponse(request);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GuliException(2001,"删除视频失败");
        }


    }



    @DeleteMapping("delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList){

        vodService.removeMoreAlyVideo(videoIdList);
        return R.ok();

    }


}
