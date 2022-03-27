package com.open.design.easystrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:41
 * @Description
 */
public class StrategyFactory {

    private Map<Integer, Strategy> map;

    public StrategyFactory() {
        List<Strategy> strategies = new ArrayList<>();

        strategies.add(new OrdinaryStrategy());
        strategies.add(new SilverStrategy());
        strategies.add(new GoldStrategy());
        strategies.add(new PlatinumStrategy());
        strategies.add(new PlatinumStrategy());

        map = strategies.stream()
                .collect(Collectors.toMap(Strategy::getType, strategy -> strategy));
    }

    //静态内部类单例
    public static class Holder {
        public static StrategyFactory instance = new StrategyFactory();
    }

    public static StrategyFactory getInstance() {
        return Holder.instance;
    }

    public Strategy get(Integer type) {
        return map.get(type);
    }
}


