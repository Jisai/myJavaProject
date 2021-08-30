package com.songj.designPattern;

import com.songj.designPattern.StrategyMode.*;
import com.songj.enumAbout.MemberVIPEnum;
import org.junit.Test;

/**
 * @ClassNamee: IfElse
 * @Description: 探讨复杂的 if-else 语句“优雅处理”的思路
 * @Author: Scott S
 * @Date: 2020-03-23 10:28
 * @Version: 1.0
 **/
public class IfElse {


    /**
     * @Description: 假设有这么一个需求：
     *
     * 一个电商系统，当用户消费满1000 金额，可以根据用户VIP等级，享受打折优惠。
     * 根据用户VIP等级，计算出用户最终的费用。
     *
     * 普通会员 不打折
     * 白银会员 优惠50元
     * 黄金会员 8折
     * 白金会员 优惠50元，再打7折
     */
    @Test
    public void test1(){
        long money = 1000;
        double result = money;
        String type = MemberVIPEnum.SILVER_VIP.getCode();
//        result = method01(money, type);
//        System.out.println("method01 result = " + result);
//        result = method02(money, type);
//        System.out.println("method02 result = " + result);
//        result = method03(money, type);
//        System.out.println("method03 result = " + result);
        result = method04(money, type);
        System.out.println("method04 result = " + result);

    }


    /**
     * 普通实现
     */
    private double method01(long money, String type) {
        double result = money;
        if (money >= 1000) {
            if (type.equals(MemberVIPEnum.SILVER_VIP.getCode())) {

                System.out.println("白银会员 优惠50元");
                result = money - 50;
            } else if (type.equals(MemberVIPEnum.GOLD_VIP.getCode())) {

                System.out.println("黄金会员 8折");
                result = money * 0.8;
            } else if (type.equals(MemberVIPEnum.PLATINUM_VIP.getCode())) {
                System.out.println("白金会员 优惠50元，再打7折");
                result = (money - 50) * 0.7;
            } else {
                System.out.println("普通会员 不打折");
                result = money;
            }
        }
        return result;
    }


    /**
     * 策略模式
     */
    private double method02(long money, String type) {
        double result = money;
        if (money >= 1000) {
            if (type.equals(MemberVIPEnum.SILVER_VIP.getCode())) {

                result = new Silver__IfElse_Strategy().compute(money);
            } else if (type.equals(MemberVIPEnum.GOLD_VIP.getCode())) {

                result = new Gold_IfElse_Strategy().compute(money);
            } else if (type.equals(MemberVIPEnum.PLATINUM_VIP.getCode())) {

                result = new Platinum_IfElse_Strategy().compute(money);
            } else {
                result = new Ordinary_IfElse_Strategy().compute(money);
            }
        }

        return result;
    }

    /**
     * 策略模式
     * 根据 type 替换为对应的 用户VIP 策略。
     * 这里代码上出现了重复的调用 compute ，我们可以尝试进一步优化。
     */
    private double method03(long money, String type) {
        double result = money;
        IfElse_Strategy strategy = new Ordinary_IfElse_Strategy();
        if (money >= 1000) {
            if (type.equals(MemberVIPEnum.SILVER_VIP.getCode())) {

                strategy = new Silver__IfElse_Strategy();
            } else if (type.equals(MemberVIPEnum.GOLD_VIP.getCode())) {

                strategy = new Gold_IfElse_Strategy();
            } else if (type.equals(MemberVIPEnum.PLATINUM_VIP.getCode())) {

                strategy = new Platinum_IfElse_Strategy();
            } else {
                strategy = new Ordinary_IfElse_Strategy();
            }
        }
        result = strategy.compute(money);
        return result;
    }

    /**
     * 工厂 +策略 模式
     */
    private double method04(long money, String type) {
        if (money < 1000) {
            return money;
        }

        IfElse_Strategy strategy =IfElse_StrategyFactory.getInstance().get(type);

        if (strategy == null){
            throw new IllegalArgumentException("please input right type");
        }

        return strategy.compute(money);
    }

}
