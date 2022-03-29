package com.open.design.strategy.example.cost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:41
 * @Description 策略工厂
 */
public class StrategyFactory {

    private Map<Integer, Strategy> map;

    public StrategyFactory() {

//        map.put(0, new OrdinaryStrategy());
//        map.put(1, new SilverStrategy());
//        map.put(2, new GoldStrategy());
//        map.put(3, new PlatinumStrategy());

        List<Strategy> strategies = new ArrayList<>();

        strategies.add(new OrdinaryStrategy());
        strategies.add(new SilverStrategy());
        strategies.add(new GoldStrategy());
        strategies.add(new PlatinumStrategy());

        map = strategies.stream()
                .collect(Collectors.toMap(Strategy::getType, strategy -> strategy));
        System.out.println(map);
    }

    public Strategy get(Integer type) {
        return map.get(type);
    }

    /**
     * 静态内部类单例
     */
    public static class Holder {
        public static StrategyFactory instance = new StrategyFactory();
    }

    public static StrategyFactory getInstance() {
        return Holder.instance;
    }

}


