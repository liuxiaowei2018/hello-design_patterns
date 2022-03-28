package com.open.design.responsibilitychain;

/**
 * @Description: 抽象Handler处理器
 * 定义处理请求的接口，并且实现后继链（successor）
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:57
 */
public abstract class Handler {

    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(Request request);

}
