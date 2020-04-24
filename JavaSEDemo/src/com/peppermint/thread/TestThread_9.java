package com.peppermint.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class TestThread_9 {
    public static void main(String[] args) {
        //使用Java自带的线程池
        /**
         * 第一个参数10表示这个线程池初始化了10个线程在里面工作
         * 第二个参数15表示如果10个线程不够用了，就会自动增加到最多15个线程
         * 第三个参数60就结合第四个参数TimeUnit.Seconds，表示经过60秒 多出来的线程还没有接到活，就会回收，最后保持池子里就10个
         * 第五个参数new LinkedBlockingQueue()用来存放任务的集合
         *
         * execute用于添加新的任务
         */
        ThreadPoolExecutor threadPool=new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        });
    }
}
