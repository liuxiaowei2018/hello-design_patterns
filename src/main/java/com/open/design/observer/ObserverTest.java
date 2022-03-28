package com.open.design.observer;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 12:29
 * @Description
 */
public class ObserverTest {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        subject.attach(new ObserverOne());
        ObserverTwo observerTwo = new ObserverTwo();
        subject.attach(observerTwo);

        subject.notifyObservers("观察者们请接收消息");

        subject.detach(observerTwo);
        subject.notifyObservers("观察者们请接收消息");
    }
}
