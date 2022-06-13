package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.commonutils.R;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-03-19
 */

//RestController : 返回json数据
//RequestMapping : 访问json数据
@Api("讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {


    //    把service注入

    @Autowired
    public EduTeacherService teacherService;

    //    1 查询讲师所有数据|
//    rest风格
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
//    public List<EduTeacher> findAllTeacher() {
    public R findAllTeacher() {
//        调用service中的方法查询所有操作
        List<EduTeacher> list = teacherService.list(null);

        return R.ok().data("items", list);
    }


    //    2逻辑删除讲师
//    id通过路径传递   @PathVariable 路径传参
    @ApiOperation(value = "根据id逻辑删除讲师")
    @DeleteMapping("{id}")
//    public boolean removeTeacher(@ApiParam(name = "id", value = "讲师id", readOnly = true) @PathVariable String id) {
    public R removeTeacher(@ApiParam(name = "id", value = "讲师id", readOnly = true) @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    //    分页查询讲师的的方法
    @ApiOperation(value = "分页查询讲师")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current, @PathVariable long limit) {
//    模拟异常

//        try {
//            int i = 10 / 0;
//        } catch (Exception e) {
//            throw new GuliException(20001, "执行自定义异常");
//        }

        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
//        调用方法实现分页  调用方法的时候将分页数据封装到pageTeacher对象里面
        teacherService.page(pageTeacher, null);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("total", total);
//        map.put("rows", records);
//        return R.ok().data(map);
//        或者直接上面写法
        return R.ok().data("total", total).data("rows", records);
    }


    //    条件查询带分页
//    @ApiOperation(value = "条件分页查询讲师")
//    @GetMapping("pageTeacherCondiction/{current}/{limit}")
//    public R pageTeacherCondiction(@PathVariable long current, @PathVariable long limit, TeacherQuery teacherQuery) {
//
//        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
//        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
//
////        多条件组合查询
//        String name = teacherQuery.getName();
//        Integer level = teacherQuery.getLevel();
//        String begin = teacherQuery.getBegin();
//        String end = teacherQuery.getEnd();
//
//        if (!StringUtils.isEmpty(name)) {
//            wrapper.like("name", name);
//        }
//
//        if (!StringUtils.isEmpty(level)) {
//            wrapper.eq("level", level);
//        }
//
//        if (!StringUtils.isEmpty(begin)) {
//            wrapper.gt("gmt_create", begin);
//        }
//
//        if (!StringUtils.isEmpty(end)) {
//            wrapper.lt("gmt_create", end);
//        }
//
//        teacherService.page(pageTeacher, wrapper);
//
//
//        long total = pageTeacher.getTotal();
//        List<EduTeacher> records = pageTeacher.getRecords();
//        return R.ok().data("total", total).data("rows", records);
//    }

    @ApiOperation(value = "条件分页查询讲师")
    @PostMapping("pageTeacherCondiction/{current}/{limit}")
    public R pageTeacherCondiction(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) TeacherQuery teacherQuery) {


        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

//        多条件组合查询
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }

        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }

        if (!StringUtils.isEmpty(begin)) {
            wrapper.gt("createtime", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            wrapper.lt("createtime", end);
        }


        wrapper.orderByDesc("createtime");
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
        teacherService.page(pageTeacher, wrapper);


        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }


    //   添加讲师接口方法
    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {

//        boolean save = teacherService.save(eduTeacher);
//        if (save) {
//            return R.ok();
//        } else return R.error();
        return teacherService.save(eduTeacher) ? R.ok() : R.error();
    }


    //    根据讲师id进行查询
    @ApiOperation("根据讲师id进行查询")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher", eduTeacher);
    }

    //    讲师修改功能
    @ApiOperation("讲师修改功能")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        return teacherService.updateById(eduTeacher) ? R.ok() : R.error();
    }


}

