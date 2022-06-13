package com.atguigu.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.entity.subject
 * @date 2022-04-05-14:57
 * @Desc:
 */

@Data
public class OneSubject {

    private String id;

    private String title;

    //    一个一级分类有多个二级分类
    private List<TwoSubject> children = new ArrayList<>();


}
