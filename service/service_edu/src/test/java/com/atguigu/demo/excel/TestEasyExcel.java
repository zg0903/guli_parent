package com.atguigu.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.demo.excel
 * @date 2022-04-04-19:56
 * @Desc: EasyExcel 测试
 */

public class TestEasyExcel {

    public static void main(String[] args) {
////        1 设置写入文件夹地址和excel文件名称
        String fileName = "D:\\excel\\write.xlsx";
//
////        2调用方法实现写操作
//        EasyExcel.write(fileName, DemoData.class).sheet("学生列表").doWrite(getData());


//        3读操作
        EasyExcel.read(fileName, DemoData.class, new ExcelListerer()).sheet().doRead();


    }


    private static List<DemoData> getData() {
        ArrayList<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setName("lucy" + i);
            list.add(data);
        }
        return list;
    }


}
