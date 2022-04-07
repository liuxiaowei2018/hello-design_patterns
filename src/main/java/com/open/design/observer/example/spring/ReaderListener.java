package com.open.design.observer.example.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Async;

/**
 * @author liuxiaowei
 * @date 2022年04月07日 14:56
 * @Description
 */
@RequiredArgsConstructor
public class ReaderListener implements ApplicationListener<SpringEvent> {

    @NonNull
    private String name;

    private String article;

    @Async
    @Override
    public void onApplicationEvent(SpringEvent event) {
        // 更新文章
        updateArticle(event);
    }

    private void updateArticle(SpringEvent event) {
        this.article = (String) event.getSource();
        System.out.printf("我是读者：%s，文章已更新为：%s\n", this.name, this.article);
    }
}
