package com.open.design.responsibilitychain;

/**
 * @Description: ConcreteHandler1
 * 构建Handler1，内部实现handleRequest方法，判断一下是否是当前处理应该处理的业务逻辑，不是则向下传递
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:58
 */
public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler successor) {
        super(successor);
    }


    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE1) {
            System.out.println(request.getName() + " is handle by ConcreteHandler1");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}


