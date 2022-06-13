package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.oss.service
 * @date 2022-04-04-11:27
 * @Desc:
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
