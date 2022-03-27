package com.open.design.strategyroutertree;

/**
 * @Author nb
 * @Date 2021/3/29 13:45
 * @Description
 */
public interface StrategyHandler<T,R> {

    StrategyHandler DEFAULT = t -> null;

    R apply(T param);
}
