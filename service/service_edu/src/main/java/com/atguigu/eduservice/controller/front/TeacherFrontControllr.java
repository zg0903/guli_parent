package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.controller.front
 * @date 2022-06-21-21:56
 * @Desc:
 */
@Api("讲师前端页面展示")
@CrossOrigin
@RestController
@RequestMapping("eduservice/teacherfront")
public class TeacherFrontControllr {

    @Autowired
    private EduTeacherService teacherService;

    //    1分页查询讲师的方法
    @PostMapping("geteTeacherFromtList/{page}/{limit}")
    public R getTeacherFront(@PathVariable long page, @PathVariable long limit) {
        Page<EduTeacher> pageTeacheer = new Page<>(page, limit);
        Map<String, Object> map = teacherService.getTeacherFrontList(pageTeacheer);
        return R.ok().data(map);
    }


}
