package com.songj.designPattern.StrategyMode;

import com.songj.enumAbout.MemberVIPEnum;

/**
 * @ClassNamee: Platinum_IfElse_Strategy
 * @Description: 白金会员策略
 * @Author: Scott S
 * @Date: 2020-03-23 15:05
 * @Version: 1.0
 **/
public class Platinum_IfElse_Strategy implements IfElse_Strategy {

    @Override
    public double compute(long money) {
        System.out.println("白金会员 优惠50元，再打7折");
        return (money - 50) * 0.7;
    }

    // 添加 type 返回
    @Override
    public String getMemberVIPType() {
        return MemberVIPEnum.PLATINUM_VIP.getCode();
    }
}
