package com.atguigu.educms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.educms
 * @date 2022-06-07-22:37
 * @Desc:
 */

@SpringBootApplication
@MapperScan("com.atguigu.educms.mapper")
@ComponentScan(basePackages = {"com.atguigu"})
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
