package com.atguigu.eduservice.entity.enumvo;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.eduservice.entity.enumvo
 * @date 2022-05-03-14:27
 * @Desc:
 */
public enum CourseStatus {
    Normal("Normal"),
    Draft("Draft");
    private String status;

    CourseStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
