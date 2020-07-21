package com.songj.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 雇员信息
 */
@Data
@ApiModel(description = "雇员类")
public class Employee implements Serializable {

    private static final long serialVersionUID = 4775629632953317597L;

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "岗位名称")
    private String positionTitle;

    @ApiModelProperty(value = "工资")
    private Integer salary;

    @ApiModelProperty(value = "入职年数")
    private Integer year;

    @ApiModelProperty(value = " 是否已离职")
    private boolean isQuit;


    public Employee() {

    }

    public Employee(Integer id, Integer level, Integer salary, Integer year) {
        this.id = id;
        this.level = level;
        this.salary = salary;
        this.year = year;
    }

    public Employee(Integer id, Integer level) {
        this.id = id;
        this.level = level;
    }

    public Employee(Integer id, Integer level, Integer salary, Integer year, boolean isQuit) {
        this.id = id;
        this.level = level;
        this.salary = salary;
        this.year = year;
        this.isQuit = isQuit;
    }

    public Employee(Integer id, String name, Integer level, String positionTitle, boolean isQuit) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.positionTitle = positionTitle;
        this.isQuit = isQuit;
    }


}
