package com.atguigu.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.demo.excel
 * @date 2022-04-05-9:35
 * @Desc:
 */
public class ExcelListerer extends AnalysisEventListener<DemoData> {

    //    行读取
    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        System.out.println("***" + data);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
        System.out.println("表头" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
