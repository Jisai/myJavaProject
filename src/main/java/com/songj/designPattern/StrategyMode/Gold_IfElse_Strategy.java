package com.songj.designPattern.StrategyMode;

import com.songj.enumAbout.MemberVIPEnum;

/**
 * @ClassNamee: Gold_IfElse_Strategy
 * @Description: 黄金会员策略
 * @Author: Scott S
 * @Date: 2020-03-23 15:03
 * @Version: 1.0
 **/
public class Gold_IfElse_Strategy implements IfElse_Strategy{

    @Override
    public double compute(long money) {
        System.out.println("黄金会员 8折");
        return money * 0.8;
    }

    // 添加 type 返回
    @Override
    public String getMemberVIPType() {
        return MemberVIPEnum.GOLD_VIP.getCode();
    }
}
