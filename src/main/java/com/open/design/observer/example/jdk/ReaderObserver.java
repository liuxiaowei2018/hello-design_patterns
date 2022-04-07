package com.open.design.observer.example.jdk;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Observable;
import java.util.Observer;

/**
 * @author liuxiaowei
 * @date 2022年04月07日 14:44
 * @Description 观察者：读者粉丝
 */
@RequiredArgsConstructor
public class ReaderObserver implements Observer {

    @NonNull
    private String name;

    private String article;

    @Override
    public void update(Observable observable, Object o) {
        updateArticle(observable);
    }

    private void updateArticle(Observable o) {
        JdkObservable javaStackObservable = (JdkObservable) o;
        this.article = javaStackObservable.getArticle();
        System.out.printf("我是读者：%s，文章已更新为：%s\n", this.name, this.article);
    }
}
