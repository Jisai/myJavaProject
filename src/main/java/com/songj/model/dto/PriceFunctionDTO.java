package com.songj.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName: abc
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2018-06-12 10:10
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class PriceFunctionDTO {
    //公式中的参数
    private String arg;
    //计量依据
    private String meteringBase;
    //计量单位
    private String meteringUnit;
    //需要替换的函数
    private String functionStr;

}