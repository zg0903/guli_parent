package com.atguigu.servicebase.exceptionhandler;

import com.atguigu.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.servicebase.exceptionhandler
 * @date 2022-03-20-14:41
 * @Desc: 异常处理
 */
//@Slf4j 日志
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //    ExceptionHandler 指定出现什么异常执行这个方法
//    ResponseBody 为了返回shuju
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理");
    }


    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理");
    }


    //    自定义异常
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e) {
//        将信异常息写入日志
        log.error(e.getMsg());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }


}
