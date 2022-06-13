package com.atguigu.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.demo.excel
 * @date 2022-04-04-19:54
 * @Desc:
 */
@Data
public class DemoData {

    //   表头
    @ExcelProperty(value = "学生编号", index = 0)
    private Integer sno;
    @ExcelProperty(value = "学生新命", index = 1)
    private String name;


}
