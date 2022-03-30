package com.open.design.routertree.example;

import com.open.design.routertree.StrategyRouter;
import com.open.design.routertree.example.entity.ReqEntity;
import com.open.design.routertree.example.entity.ResEntity;
import com.open.design.routertree.example.strategy.Strategy1;
import com.open.design.routertree.example.strategy.Strategy2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaowei
 * @date 2022年03月30日 12:41
 * @Description 策略分发的根节点
 */
@Service
public class StrategyRootNode extends StrategyRouter<ReqEntity, ResEntity> {

    @Autowired
    private Strategy1 strategy1;
    @Autowired
    private Strategy2 strategy2;

    @Override
    protected StrategyMapper<ReqEntity, ResEntity> registerStrategyMapper() {
        return param -> {
            int type=param.getType();
            if(type==1){
                return strategy1.getStrategyMapper().get(param);
            }
            if(type>1){
                return strategy2;
            }
            return null;
        };
    }

}
