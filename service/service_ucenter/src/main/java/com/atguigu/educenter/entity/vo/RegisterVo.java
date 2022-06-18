package com.atguigu.educenter.entity.vo;

/**
 * @author zhuguang
 * @Project_name guli_parent
 * @Package_name com.atguigu.educenter.entity.vo
 * @date 2022-06-18-17:40
 * @Desc:
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterVo {
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "验证码")
    private String code;
}
