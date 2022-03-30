//package com.open.design.routertree.example;
//
//import com.open.design.routertree.StrategyHandler;
//import com.open.design.routertree.StrategyRouter;
//import com.open.design.routertree.example.entity.ReqEntity;
//import com.open.design.routertree.example.entity.ResEntity;
//import com.open.design.routertree.example.strategy.Strategy1;
//import com.open.design.routertree.example.strategy.Strategy2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author liuxiaowei
// * @date 2022年03月30日 12:41
// * @Description 策略分发的根节点-map实现
// */
//@Service
//public class StrategyRootNodeByMap extends StrategyRouter<ReqEntity, ResEntity> {
//
//    @Autowired
//    private Strategy1 strategy1;
//    @Autowired
//    private Strategy2 strategy2;
//
//    /**
//     * 定义用来存储执行策略的map集合
//     */
//    private Map<ReqEntity, StrategyHandler> strategyMap = new HashMap();
//
//    @Override
//    protected StrategyMapper<ReqEntity, ResEntity> registerStrategyMapper() {
//        ReqEntity reqEntity1 = new ReqEntity();
//        reqEntity1.setType(1);
//        ReqEntity reqEntity2 = new ReqEntity();
//        reqEntity2.setType(2);
//        strategyMap.put(reqEntity1,strategy1);
//        strategyMap.put(reqEntity2,strategy2);
//        return new RootStrategyMapper();
//    }
//
//    /**
//     * 实现父类定义的接口，用于实现自己的获取不同的策略
//     */
//    class RootStrategyMapper implements StrategyMapper<ReqEntity, ResEntity>{
//        @Override
//        public StrategyHandler<ReqEntity, ResEntity> get(ReqEntity param) {
//            return strategyMap.get(param);
//        }
//    }
//}
