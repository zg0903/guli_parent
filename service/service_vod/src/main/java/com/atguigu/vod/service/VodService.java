package com.atguigu.vod.service;

import com.atguigu.vod.service.impl.VodServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.vod.service
 * @date 2022-05-15-15:42
 * @Desc:
 */

public interface VodService {
    public String uploadVideAly(MultipartFile file);

    void removeMoreAlyVideo(List videoIdList);
}
