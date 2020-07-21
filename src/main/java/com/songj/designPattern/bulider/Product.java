package com.songj.designPattern.bulider;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassNamee: Product
 * @Description: 产品角色：包含多个组成部件的复杂对象。
 * 产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件。
 * @Author: Scott S
 * @Date: 2020-05-28 15:26
 * @Version: 1.0
 **/
@Getter
@Setter
public class Product implements Serializable {

    private String partA;

    private String partB;

    private String partC;

    public void show() {

        //显示产品的特性
        System.out.println("显示产品的特性: ");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}
