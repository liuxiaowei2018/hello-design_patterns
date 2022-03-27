package com.open.design.factory.factorymethod.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 0:40
 * @Description 分享模板
 */
@Component
public class ShareFactory {

    @Autowired
    private List<Share> shareFunctionList;

    public Share getShareFunction(String type) {
        for (Share share : shareFunctionList) {
            if (share.getShareFunctionType().equals(type)) {
                return share;
            }
        }
        return null;
    }
}
