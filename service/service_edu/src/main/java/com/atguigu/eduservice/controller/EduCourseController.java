package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.enumvo.CourseStatus;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.entity.vo.CourseQuery;
import com.atguigu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-04-07
 */

@Api("课程添加模块")
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;


    //    课程列表
    @GetMapping
    public R getCourseList() {
        List<EduCourse> list = courseService.list(null);
        return R.ok().data("list", list);
    }

    //    分页查询课程
    @ApiOperation(value = "分页查询课程")
    @GetMapping("pageQuery/{current}/{limit}}")
    public R pageListCourse(@PathVariable long current, @PathVariable long limit) {
        Page<EduCourse> pageCourse = new Page<>(current, limit);
        courseService.page(pageCourse, null);
        long total = pageCourse.getTotal();
        List<EduCourse> records = pageCourse.getRecords();
        return R.ok().data("total", total).data("rows", records);

    }


    //    条件分页查询
    @ApiOperation(value = "条件分页查询")
    @PostMapping("pageCourseCondiction/{current}/{limit}")
    public R pageCourseCondiction(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) CourseQuery courseQuery) {
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        String coursename = courseQuery.getCoursename();
        String status = courseQuery.getStatus();

        if (!StringUtils.isEmpty(coursename)) {
            wrapper.like("title", coursename);
        }
        if (!StringUtils.isEmpty(status)) {
            wrapper.like("status", status);
        }
        Page<EduCourse> pageCourse = new Page<>(current, limit);
        courseService.page(pageCourse, wrapper);

        long total = pageCourse.getTotal();
        List<EduCourse> records = pageCourse.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }


    //    添加课程基本信息  使用vo类  向课程表和课程描述表添加信息
    @ApiOperation(value = "添加课程")
    @PostMapping("addCourseInfo")
    public R addCourse(@RequestBody CourseInfoVo courseInfoVo) {
//        返回添加之后课程id  为了后面添加大纲使用
        String id = courseService.saveCourseInfo(courseInfoVo);

        return R.ok().data("courseid", id);
    }

    //根据课程id查询课程基本信息
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo", courseInfoVo);
    }

    //修改课程信息
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }


    //    根据课程id查询课程确认信息
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo coursePublishVo = courseService.publishCourseInfo(id);
        return R.ok().data("publishCourse", coursePublishVo);
    }

    //    课程最终发布 修改课程状态
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus(CourseStatus.Normal.toString()); //设置课程发布状态  Draft  Normalco
        courseService.updateById(eduCourse);
        return R.ok();
    }


    //    删除课程
    @ApiOperation(value = "删除课程")
    @DeleteMapping("{courseId}")
    public R deleteCourse(@PathVariable String courseId) {
        courseService.removeCourse(courseId);

        return R.ok();
    }


}

