package com.atguigu.educenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.educenter
 * @date 2022-06-15-21:54
 * @Desc:
 */
@SpringBootApplication
@ComponentScan("com.atguigu")
@MapperScan("com.atguigu.educenter.mapper")
public class UcenterApplicationm {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplicationm.class, args);
    }
}
