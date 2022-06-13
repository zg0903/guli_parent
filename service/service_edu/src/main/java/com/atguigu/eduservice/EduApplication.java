package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice
 * @date 2022-03-19-10:59
 * @Desc: 启动类
 */

//ComponentScan  设置扫描  扫描service_base下的SwaggerConfig
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
@EnableDiscoveryClient //nacos注册
@EnableFeignClients //调用
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
