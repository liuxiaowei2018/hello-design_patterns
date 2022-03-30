package com.open.design.routertree;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * 策略路由，根据入参来决定执行哪个策略
 * 通过实现 {@code StrategyRouter} 抽象类来完成策略的分发，只有根节点和子节点需要实现这个类，叶节点无需实现这个类
 * 通过实现 {@code StrategyHandler} 接口来实现不同策略的具体执行逻辑
 * 根节点只负责根据入参进行策略分发，只需要实现StrategyRouter抽象类，而子节点既负责策略的分发，也需要实现不同的策略，所以子节点需要实现StrategyHandler接口
 * 叶节点不需要根据入参进行策略分发，所以只需要实现StrategyHandler就可以了
 * <pre>
 *           +---------+
 *           |  Root   |   ----------- 第 1 层策略入口
 *           +---------+
 *            /       \  ------------- 根据入参 P1 进行策略分发
 *           /         \
 *     +------+      +------+
 *     |  A   |      |  B   |  ------- 第 2 层不同策略的实现
 *     +------+      +------+
 *       /  \          /  \  --------- 根据入参 P2 进行策略分发
 *      /    \        /    \
 *   +---+  +---+  +---+  +---+
 *   |A1 |  |A2 |  |B1 |  |B2 |  ----- 第 3 层不同策略的实现
 *   +---+  +---+  +---+  +---+
 * </pre>
 * @param <T> 入参
 * @param <R> 返回值
 * @Author liuxiaowei
 * @Date 2021/3/29 13:14
 * @Description
 * 如果子节点路由逻辑比较简单，可以直接通过 if-else 进行分发。当然如果为了更好地性能、适应更复杂的分发逻辑也可以使用 Map 等保存映射。
 * 对于实现了该抽象类的 Router 节点，只需要调用其 publicR applyStrategy(T param) 方法即可获取该节点的期望输出。
 * 框架会自动根据定义的路由逻辑将 param 传递到对应的子节点，再由子节点不断向下分发直到叶子节点或可以给出业务输出的一层。这个过程有点类似递归或者分治的思想。
 */
public abstract class StrategyRouter<T, R> {

    /**
     * 策略的映射器，根据入参来路由到指定的策略执行者
     *
     * @param <T>
     * @param <R>
     */
    public interface StrategyMapper<T, R> {

        /**
         * 根据入参获取到对应的策略执行者
         * 可通过 if-else 实现，也可通过 Map 实现。
         *
         * @param param 入参
         * @return 具体的执行者
         */
        StrategyHandler<T, R> get(T param);
    }

    /**
     * 在类初始化时，会调用初始化类（也就是实现类）的registerStrategyMapper()方法获取到接口的实现
     */
    private StrategyMapper<T, R> strategyMapper;

    /**
     * 类初始化时注册分发策略 Mapper
     */
    @PostConstruct
    private void abstractInit() {
        strategyMapper = registerStrategyMapper();
        // 未找到策略分发者
        Objects.requireNonNull(strategyMapper, "strategyMapper cannot be null");
    }

    @Getter
    @Setter
    @SuppressWarnings("unchecked")
    private StrategyHandler<T, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    /**
     * 执行方法
     * @param param 入参
     * @return 返回值
     */
    public R applyStrategy(T param) {
        // 调用实现StrategyMapper接口的匿名类的get方法
        // 此时get方法会根据入参，返回对应的策略执行者，再调用apply方法
        final StrategyHandler<T, R> strategyHandler = strategyMapper.get(param);
        if (strategyHandler != null) {
            return strategyHandler.apply(param);
        }
        return defaultStrategyHandler.apply(param);
    }

    /**
     * 分发策略的具体实现
     * @return 策略映射器
     */
    protected abstract StrategyMapper<T, R> registerStrategyMapper();

    public StrategyMapper<T,R> getStrategyMapper(){
        return strategyMapper;
    }

}
