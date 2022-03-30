package com.open.design.routertree.example.strategy;

import com.open.design.routertree.StrategyHandler;
import com.open.design.routertree.StrategyRouter;
import com.open.design.routertree.example.entity.ReqEntity;
import com.open.design.routertree.example.entity.ResEntity;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaowei
 * @date 2022年03月30日 12:43
 * @Description 策略二-叶子节点
 */
@Service
public class Strategy2 implements StrategyHandler<ReqEntity, ResEntity> {

    @Override
    public ResEntity apply(ReqEntity param) {
        System.out.println("Strategy2");
        return new ResEntity();
    }

}
