package com.songj.enumAbout;

import java.util.HashMap;
import java.util.Map;

public enum SexEnum implements CodeBaseEnum{

    MAN("MAN", "男"),
    WOMAN("WOMAN", "女");

    private String code;

    private String name;

    SexEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

//    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
//        for (T each: enumClass.getEnumConstants()) {
//            if (code.equals(each.getCode())) {
//                return each;
//            }
//        }
//        return null;
//    }

}
