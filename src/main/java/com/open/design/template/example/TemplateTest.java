package com.open.design.template.example;

/**
 * @author liuxiaowei
 * @date 2022年03月29日 12:20
 * @Description
 */
public class TemplateTest {
    public static void main(String[] args) {

        // 公司A请假流程模版
        AskForLeaveFlow companyA = new CompanyA();
        companyA.askForLeave("A-小米");
        // 结果：CompanyA 组内有人请假，请假人：A-小米
        //       当前有人请假了，请假人：A-小米

        AskForLeaveFlow companyB = new CompanyB();
        companyB.askForLeave("B-华为");
        // 结果：CompanyB 组内有人请假，请假人：B-华为
        //      CompanyB 部门有人请假，请假人：B-华为
        //      当前有人请假了，请假人：B-华为
    }
}
