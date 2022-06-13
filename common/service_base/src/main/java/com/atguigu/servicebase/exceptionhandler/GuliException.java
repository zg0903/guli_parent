package com.atguigu.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.servicebase.exceptionhandler
 * @date 2022-03-20-15:29
 * @Desc:
 */

//@AllArgsConstructor  生成有参构造器   @NoArgsConstructor 生成无参构造

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuliException extends RuntimeException {
    private Integer code; //状态码
    private String msg; //异常msg


}
