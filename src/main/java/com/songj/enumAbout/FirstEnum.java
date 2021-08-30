package com.songj.enumAbout;

import java.util.Objects;

public enum FirstEnum {

    FIRSTENUM(1, "第一"),
    SECOND(2, "第二");

    private final int code;
    private final String name;

    FirstEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static FirstEnum getEnum(int  code){
        if(Objects.isNull(code)){
            return  null;
        }
        for(FirstEnum one : FirstEnum.values()){
            if(one.getCode() == code){
                return one;
            }
        }
        return  null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
