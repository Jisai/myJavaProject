package com.songj.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "人员")
public class People{

	@ApiModelProperty(value = "人员ID")
	private Integer id;

	@ApiModelProperty(value = "名字")
	private Integer name;

	@ApiModelProperty(value = "辈分")
	private Integer seniorityInTheFamily;

	@ApiModelProperty(value = "孩子")
	private People son;


}
