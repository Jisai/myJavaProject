package com.songj.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: Parent
 * @Description: 通用父类，用于测试
 * @Author: Scott S
 * @Date: 2018-06-01 15:53
 * @Version: 1.0
 */
@Data
@ApiModel(description = "通用父类，用于测试")
public class Parent {

    @ApiModelProperty(value = "父级ID")
    private Long parentId;

    @ApiModelProperty(value = "创建人ID")
    private Long creatUserId;

    @ApiModelProperty(value = "创建人姓名")
    private String creatUserName;

    @ApiModelProperty(value = "创建时间（ms）")
    private Long createTime;

    @ApiModelProperty(value = "更新人ID")
    private Long updateUserId;

    @ApiModelProperty(value = "更新时间（ms）")
    private Long updateTime;

    @ApiModelProperty(value = "更新人姓名")
    private String updateUserName;

    @ApiModelProperty(value = "ID集合")
    List<Long> idList;
}