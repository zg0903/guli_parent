package com.atguigu.servicebase.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.servicebase.handle
 * @date 2022-03-20-13:58
 * @Desc:
 */

@Component
public class MymetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createtime", new Date(), metaObject);
        this.setFieldValByName("updatetime", new Date(), metaObject);
        this.setFieldValByName("gmtcreate", new Date(), metaObject);
        this.setFieldValByName("gmtmodified", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatetime", new Date(), metaObject);
        this.setFieldValByName("gmtmodified", new Date(), metaObject);
    }
}
