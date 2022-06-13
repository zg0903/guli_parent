package com.atguigu.eduservice.entity.vo;

import lombok.Data;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.entity.vo
 * @date 2022-05-03-11:52
 * @Desc:
 */

@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessNum;
    private String subjectlevelone;

    private String subjectlevelTew;
    private String teachername;
    private String price;
}
