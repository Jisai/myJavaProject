package com.songj.enumAbout;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EnumTests {

    @Test
    public void firstEnum(){
        int code =1;
        FirstEnum oneEnum = FirstEnum.getEnum(code);
        System.out.println(oneEnum.getCode());
        System.out.println(oneEnum.getName());
    }

    @Test
    public void dataEnum(){
        int code =1;
        DataEnum oneEnum = DataEnum.getEnum(code);
        System.out.println(oneEnum.getCode());
        System.out.println(oneEnum.getName());
    }

    @Test
    public void enumList(){
        System.out.println(JSON.toJSONString(FirstEnum.values()));
    }

    @Test
    public void isBlone(){
        String code1 = "";
        System.out.println(DataEnum.isBelong(code1));
        String code2 = "FIRST";
        System.out.println(DataEnum.isBelong(code2));
    }

    @Test
    public void getKVs(){



    }


}
