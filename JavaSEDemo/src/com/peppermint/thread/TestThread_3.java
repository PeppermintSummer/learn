package com.peppermint.thread;

public class TestThread_3 {
    public static void main(String[] args) {
        final Hero garen=new Hero();
        garen.name="盖伦";
        garen.hp=3000;
        System.out.println("盖伦的初始血量为："+garen.hp);

        //多线程同步问题指的是多个线程同时修改一个数据时导致的问题
        //假如盖伦有3000血量，在被打的同时自己还会回血
        int n=3000;
        Thread[] addThread=new Thread[n];
        Thread[] reduceThread=new Thread[n];

        for (int i=0;i<n;i++){
            Thread t=new Thread(){
                public void run(){
                    garen.recover();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread[i]=t;
        }

        for (int i=0;i<n;i++){
            Thread t=new Thread(){
                public void run(){
                    garen.hurt();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThread[i]=t;
        }

        //等待所有增加、减少线程结束
        for (Thread thread : addThread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread thread : reduceThread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束之后  观察到盖伦的血量变成了"+garen.hp);
    }
}
