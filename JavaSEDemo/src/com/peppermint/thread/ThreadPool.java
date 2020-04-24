package com.peppermint.thread;

import java.util.LinkedList;

public class ThreadPool {
    int threadPoolSize;

    //任务容器
    LinkedList<Runnable> tasks=new LinkedList<>();

    //试图消费任务的线程
    public ThreadPool(){
        threadPoolSize=10;
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumerThread("任务消费者线程"+i).start();
            }
        }
    }

    public void add(Runnable r){
        synchronized (tasks){
            tasks.add(r);
            tasks.notifyAll();
        }
    }

    class TaskConsumerThread extends Thread{
        public TaskConsumerThread(String name){
            super(name);
        }

        Runnable task;

        public void run(){
            System.out.println("启动" +this.getName());
            while (true){
                synchronized (tasks){
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task=tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName()+"获取到任务，并且执行!");
                task.run();
            }
        }
    }

}
