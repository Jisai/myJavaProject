package com.songj.designPattern.StrategyMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassNamee: IfElse_StrategyFactory
 * @Description: 工厂 + 策略 模式
 * 创建一个 StrategyFactory 工厂类。
 * StrategyFactory 这里我使用的是静态内部类单例，
 * 在构造方法的时候，初始化好 需要的 Strategy，并把 list 转化为 map。
 **/
public class IfElse_StrategyFactory {

    private Map<String, IfElse_Strategy> map;

    public IfElse_StrategyFactory() {

        List<IfElse_Strategy> strategies = new ArrayList<>();

        strategies.add(new Ordinary_IfElse_Strategy());
        strategies.add(new Silver__IfElse_Strategy());
        strategies.add(new Gold_IfElse_Strategy());
        strategies.add(new Platinum_IfElse_Strategy());


        // 看这里 看这里 看这里！
        map = strategies.stream().collect(Collectors.toMap(IfElse_Strategy::getMemberVIPType, strategy -> strategy));

        /* 等同上面
        map = new HashMap<>();
        for (IfElse_Strategy strategy : strategies) {
            map.put(strategy.getMemberVIPType(), strategy);
        }*/
    }

    //静态内部类单例，单例模式实现的一种，不是本文重点，如不了解，可以自行 google。
    public static class Holder {
        public static IfElse_StrategyFactory instance = new IfElse_StrategyFactory();
    }

    public static IfElse_StrategyFactory getInstance() {
        return Holder.instance;
    }

    public IfElse_Strategy get(String type) {
        return map.get(type);
    }
}

