package com.duck.service.impl;

import com.duck.proxy.PerformanceMonitor;

public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
//        PerformanceMonitor.begin("com.duck.service.impl.ForumServiceImpl#removeTopic");
        System.out.println("模拟删除Topic记录：" + topicId);
//        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
//        PerformanceMonitor.begin("com.duck.service.impl.ForumServiceImpl#removeForum");
        System.out.println("模拟删除Forum记录：" + forumId);
//        PerformanceMonitor.end();
    }
}
