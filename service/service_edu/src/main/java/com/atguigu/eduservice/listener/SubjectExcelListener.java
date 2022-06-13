package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.listener
 * @date 2022-04-05-10:01
 * @Desc:
 */

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    /*
        SubjectExcelListener 不能交给spring进行管理 需要自己new
        不能注入其他对象  不能实现数据库操作
     */
    public EduSubjectService subjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData data, AnalysisContext context) {
        /*
        行读取  第一个值以及分类 第二个值二级分类
         */
        if (data == null) {
            throw new GuliException(2001, "文件数据为空");
        }
        EduSubject existOneSubject = this.existOneSubject(subjectService, data.getOneSubjectName());
        if (existOneSubject == null) {
            existOneSubject = new EduSubject();
            existOneSubject.setParentid("0");
            existOneSubject.setTitle(data.getOneSubjectName());
            subjectService.save(existOneSubject);
        }

        String pid = existOneSubject.getId();
        EduSubject existTwoSubject = this.existTwoSubject(subjectService, data.getTwoSubjectName(), pid);
        if (existTwoSubject == null) {
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentid(pid);
            existTwoSubject.setTitle(data.getTwoSubjectName());
            subjectService.save(existTwoSubject);
        }


    }


    //    判断一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService subjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parentid", "o");
        EduSubject oneSubject = subjectService.getOne(wrapper);
        return oneSubject;
    }


    //    判断二级分类不能重复添加

    private EduSubject existTwoSubject(EduSubjectService subjectService, String name, String pid) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parentid", pid);
        EduSubject twoSubject = subjectService.getOne(wrapper);
        return twoSubject;
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
