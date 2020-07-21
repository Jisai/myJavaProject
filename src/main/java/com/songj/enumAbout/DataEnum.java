package com.songj.enumAbout;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName: DataEnum
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2019/7/29 14:16
 * @Version: 1.0
 **/
@Getter
public enum DataEnum implements Serializable {

    FIRST(1, "FIRST", "第一"),
    SECOND(2,"SECOND", "第二");

    private final int id;

    private final String code;

    private final String name;

    DataEnum(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public static DataEnum getEnum(int id){
        if(Objects.isNull(id)){
            return  null;
        }
        for(DataEnum one : DataEnum.values()){
            if(one.getId() == id){
                return one;
            }
        }
        return  null;
    }

    public static boolean isBelong(String code){
        if(StringUtils.isBlank(code)){
            return false;
        }
        for(DataEnum one : DataEnum.values()){
            if(code.equals(one.getCode())){
                return true;
            }
        }
        return false;
    }

}
