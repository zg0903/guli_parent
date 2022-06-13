package com.atguigu.oss.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.atguigu.oss.service.OssService;
import com.atguigu.oss.utils.ConstantPropertiesUtils;
import io.swagger.annotations.Api;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.oss.service.impl
 * @date 2022-04-04-11:28
 * @Desc:
 */

@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {


        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
//        生成uuid 替代-为空格
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        2022/04/4
        String datePath = new DateTime().toString("yyyy/MM/dd");


        String fileName = file.getOriginalFilename();

        String fileNameNew = datePath + "/" + uuid + fileName;


        String url = "https://" + bucketName + "." + endpoint + "/" + fileNameNew;

        System.out.println(url);

        // 创建OSSClient实例。
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//                .build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            ossClient.putObject(bucketName, fileNameNew, inputStream);
        } catch (OSSException | IOException oe) {
            oe.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
//                https://zg-oss-sotre.oss-cn-beijing.aliyuncs.com/106.jpg
            }
        }
        System.out.println(url);
        return url;
    }
}
