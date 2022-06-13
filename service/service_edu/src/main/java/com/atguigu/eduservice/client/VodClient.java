package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.client
 * @date 2022-05-19-17:41
 * @Desc: 微服务调用service-vod
 */

@Component
@FeignClient(name = "service-vod", fallback = VodFileDegradeFeignClient.class)  //容错则执行VodFileDegradeFeignClient的方法
public interface VodClient {

    //    定义调用方法路径
    @DeleteMapping("/eduvod/video/removeAlyVided/{id}")
    public R removeAlyVideo(@PathVariable("id") String id);

    //    删除多个视频
    @DeleteMapping("/eduvod/video/delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);

}
