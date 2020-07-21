package com.songj.designPattern.StrategyMode;

import com.songj.enumAbout.MemberVIPEnum;

/**
 * @ClassNamee: Silver__IfElse_Strategy
 * @Description: 白银会员策略
 * @Author: Scott S
 * @Date: 2020-03-23 15:02
 * @Version: 1.0
 **/
public class Silver__IfElse_Strategy implements IfElse_Strategy{

    @Override
    public double compute(long money) {

        System.out.println("白银会员 优惠50元");
        return money - 50;
    }

    // 添加 type 返回
    @Override
    public String getMemberVIPType() {
        return MemberVIPEnum.SILVER_VIP.getCode();
    }
}
