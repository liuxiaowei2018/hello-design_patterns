package com.open.design.template.example;

/**
 * @author liuxiaowei
 * @date 2022年03月29日 12:16
 * @Description 请假流程
 */
public abstract class AskForLeaveFlow {

    /**
     * 一级组长直接审批
     * 子类必须实现
     *
     * @param name
     */
    protected abstract void firstGroupLeader(String name);

    /**
     * 二级组长部门负责人审批
     * 子类可以重写，也可不重写
     *
     * @param name
     */
    protected void secondGroupLeader(String name) {
        // 子类扩展
    }

    /**
     * 告知HR有人请假了
     * 内部实现
     *
     * @param name
     */
    private final void notifyHr(String name) {
        System.out.println("当前有人请假了，请假人：" + name);
    }

    /**
     * 请假流程模版
     *
     * @param name
     */
    public void askForLeave(String name) {
        firstGroupLeader(name);
        secondGroupLeader(name);
        notifyHr(name);
    }
}
