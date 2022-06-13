package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.entity.vo
 * @date 2022-03-20-10:36
 * @Desc:
 */
@Data
public class TeacherQuery {

    @ApiModelProperty(value = "教师名称")
    private String name;
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;
    @ApiModelProperty(value = "查询开始时间")
    private String begin;
    @ApiModelProperty(value = "查询结束时间")
    private String end;


}
