package com.songj.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@ApiModel(description = "用户信息类")
public class UserInfoDO implements Serializable {

	@ApiModelProperty(value = "人员ID")
	private Integer id;

	@ApiModelProperty(value = "人员姓名")
	private String name;

	@ApiModelProperty(value = "人员年龄")
	private Integer age;

	@ApiModelProperty(value = "地址")
	private String adress;

	@ApiModelProperty(value = "删除")
	private Integer deleted;

	@ApiModelProperty(value = "编码")
	private String code;


}
