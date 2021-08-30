package com.songj.designPattern.StrategyMode;

import com.songj.enumAbout.MemberVIPEnum;

/**
 * @ClassNamee: Ordinary_IfElse_Strategy
 * @Description: 普通会员策略
 * @Author: Scott S
 * @Date: 2020-03-23 15:00
 * @Version: 1.0
 **/
public class Ordinary_IfElse_Strategy implements IfElse_Strategy {



    @Override
    public double compute(long money) {
        System.out.println("普通会员 不打折");
        return money;
    }

    // 添加 type 返回
    @Override
    public String getMemberVIPType() {
        return MemberVIPEnum.ORDINARY_VIP.getCode();
    }
}
