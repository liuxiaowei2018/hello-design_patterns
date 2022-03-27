package com.open.design.factory.factorymethod.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 0:46
 * @Description
 */
@Component
public class SuccessOrderShare implements Share{

    @Override
    public String getShareFunctionType() {
        return ShareTypeEnum.SUCCESS_ORDER.getName();
    }

    @Override
    public String mainProcess(String shareName) {
        System.out.println("业务逻辑处理...");
        return shareName;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ShareFactory shareFactory = (ShareFactory) applicationContext.getBean("shareFactory");
        Share shareFunction = shareFactory.getShareFunction(ShareTypeEnum.SUCCESS_ORDER.getName());
        String process = shareFunction.mainProcess("成功处理");
        System.out.println(process);
    }
}
