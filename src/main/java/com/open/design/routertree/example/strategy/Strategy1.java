package com.open.design.routertree.example.strategy;

import com.open.design.routertree.StrategyHandler;
import com.open.design.routertree.StrategyRouter;
import com.open.design.routertree.example.entity.ReqEntity;
import com.open.design.routertree.example.entity.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaowei
 * @date 2022年03月30日 12:43
 * @Description 策略一-中间节点
 */
@Service
public class Strategy1 extends StrategyRouter<ReqEntity, ResEntity> implements StrategyHandler<ReqEntity, ResEntity> {

    /**
     * 叶子节点
     */
    @Autowired
    private Strategy3 strategy3;

    @Override
    protected StrategyMapper<ReqEntity, ResEntity> registerStrategyMapper() {
        return param -> {
            Double childVersion = param.getChildVersion();
            if(childVersion == null){
                return this;
            }
            if(childVersion>0){
                return strategy3;
            }
            return null;
        };
    }

    @Override
    public ResEntity apply(ReqEntity param) {
        System.out.println("Strategy1");
        return new ResEntity();
    }
}
