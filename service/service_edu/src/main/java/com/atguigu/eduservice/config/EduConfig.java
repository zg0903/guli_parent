package com.atguigu.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.confif
 * @date 2022-03-19-11:06
 * @Desc:
 */


@Configuration
@MapperScan("com.atguigu.eduservice.mapper")
public class EduConfig {


    //    逻辑删除
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();

    }

    //    分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}


