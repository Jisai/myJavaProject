package com.songj.enumAbout;

public enum MemberVIPEnum {

    ORDINARY_VIP("ORDINARY_VIP", "普通会员"),
    SILVER_VIP("SILVER_VIP", "白银会员"),
    GOLD_VIP("GOLD_VIP", "黄金会员"),
    PLATINUM_VIP("PLATINUM_VIP", "白金会员");

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    MemberVIPEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
