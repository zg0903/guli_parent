package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.entity.vo
 * @date 2022-05-03-16:10
 * @Desc:
 */
@Data
public class CourseQuery {
    @ApiModelProperty(value = "课程名称")
    private String coursename;
    @ApiModelProperty(value = "课程状态")
    private String status;

}
