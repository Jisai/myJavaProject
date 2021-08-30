package com.songj.enumAbout;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum AgreementStatusEnum{

	DETELED(-1,"删除"),
    DRAFT(1,"草稿"),
    INEFFECTIVE(2,"未生效"),
    INFORCE(3, "已生效"),
    EXPIRED(4,"已失效"),
    STOP(5, "终止");

    private final int code;
    private final String name;

    AgreementStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }


    public int code() {
        return code;
    }

    @JsonCreator
    public static AgreementStatusEnum getEnum(int code){
        if (Objects.isNull(code)) {
            return null;
        }
        for (AgreementStatusEnum one : AgreementStatusEnum.values()) {
            if (one.getCode() == code) {
                return one;
            }
        }
        return null;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
