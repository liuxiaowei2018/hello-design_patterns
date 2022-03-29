package com.open.design.template.example;

/**
 * @author liuxiaowei
 * @date 2022年03月29日 12:18
 * @Description
 */
public class CompanyA extends AskForLeaveFlow{

    @Override
    protected void firstGroupLeader(String name) {
        System.out.println("CompanyA 组内有人请假，请假人：" + name);
    }
}
