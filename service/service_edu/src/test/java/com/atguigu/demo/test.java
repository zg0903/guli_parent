package com.atguigu.demo;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.demo
 * @date 2022-03-28-21:27
 * @Desc:
 */
public class test {

    @Autowired
    public EduTeacherService teacherService;

    @Test
    public void findAllTeacher() {
//        调用service中的方法查询所有操作
        List<EduTeacher> list = teacherService.list(null);
        System.out.println(list);

//        return R.ok().data("items", list);
    }
}
