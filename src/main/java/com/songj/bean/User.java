package com.songj.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@ApiModel(description = "用户类")
public class User extends Parent {

	@ApiModelProperty(value = "人员ID")
	private Integer userId;

	@ApiModelProperty(value = "人员姓名")
	private String userName;

	@ApiModelProperty(value = "人员年龄")
	private Integer userAge;

	@ApiModelProperty(value = "人员性别名称")
	private String userSex;

	@ApiModelProperty(value = "人员家庭住址")
	private String userHomeAdress;

	@ApiModelProperty(value = "人员薪资")
	private Integer userSalary;

	@ApiModelProperty(value = "创建时间（ms）")
	private Long createTime;

	@ApiModelProperty(value = "UserList")
	List<User> userList;

	@ApiModelProperty(value = "UserSet")
	Set<User> userSet;

	@ApiModelProperty(value = "ID集合")
	List<Long> idList;

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", userAge=" + userAge +
				", userSex=" + userSex +
				", userHomeAdress='" + userHomeAdress + '\'' +
				", userSalary=" + userSalary +
				", createTime=" + createTime +
				", userList=" + userList +
				", userSet=" + userSet +
				", idList=" + idList +
				'}';
	}
}
