package com.open.design.routertree;

/**
 * 策略处理者，所有节点（根节点除外）都必须实现这个接口
 * @param <T> 接口入参
 * @param <R> 接口返回值
 * @Author liuxiaowei
 * @Date 2021/3/29 13:45
 * @Description
 * 对于其他责任树中的中间层节点，都需要同时继承 Router 抽象类和实现 Handler 接口，再 R apply(T param);
 * 方法中首先进行一定异常入参拦截，遵循 fail-fast 原则，避免将这一层可以拦截的错误传递到下一层，同时也要避免「越权」做非本层职责的拦截校验，避免产生耦合，为后面业务拓展挖坑。
 * 在拦截逻辑后直接调用本身 Router 的 publicR applyStrategy(T param) 方法路由给下游节点即可。
 */
public interface StrategyHandler<T, R> {

    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     * @param param
     * @return
     */
    R apply(T param);
}
