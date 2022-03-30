package com.open.design.routertree.example;

import com.open.design.routertree.example.entity.ReqEntity;
import com.open.design.routertree.example.entity.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @date 2022年03月30日 12:55
 * @Description
 */
@RestController
public class MainTest {

    @Autowired
    private StrategyRootNode strategyRootNode;

    @RequestMapping("/getStrategy")
    public ResEntity getStrategy(ReqEntity reqEntity) {
        reqEntity.setType(1);
        reqEntity.setChildVersion(1.00);
        return strategyRootNode.applyStrategy(reqEntity);
    }
}
