package com.songj.designPattern.StrategyMode;

/**
 * @ClassNamee: IfElse_Strategy
 * @Description: if else 的策略模式
 * @Author: Scott S
 * @Date: 2020-03-23 14:42
 * @Version: 1.0
 **/
public interface IfElse_Strategy {

    //计费方法
    double compute(long money);

    //返回type
    String getMemberVIPType();

}
