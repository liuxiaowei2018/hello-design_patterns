package com.open.design.responsibilitychain;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 11:02
 */
public class ResponsibilityChainClient {

    public static void main(String[] args) {

        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);

        Request request1 = new Request(RequestType.TYPE1, "request1");
        handler2.handleRequest(request1);

        Request request2 = new Request(RequestType.TYPE2, "request2");
        handler2.handleRequest(request2);
    }

    //request1 is handle by ConcreteHandler1
    //request2 is handle by ConcreteHandler2

}
