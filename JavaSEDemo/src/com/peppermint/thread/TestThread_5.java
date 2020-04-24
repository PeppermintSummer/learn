package com.peppermint.thread;

import java.util.Arrays;

public class TestThread_5 {
    public static void main(String[] args) {
        //someObject在同一时间，只能被一个线程占用,间接的导致同一时间，hp只能被一个线程修改
        final Object someObject=new Object();
        final Hero garen=new Hero();
        garen.name="盖伦";
        garen.hp=50000;

        int n=10000;
        Thread[] addThread=new Thread[n];
        Thread[] reduceThread=new Thread[n];

        for (int i = 0; i <n; i++) {
            Thread t=new Thread(){
                public void run(){
                    //任何线程想要修改hp的值，必须占用someObject
                    synchronized (someObject) {
                        garen.recover();
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread[i]=t;
        }

        for (int i = 0; i < n; i++) {
            Thread t=new Thread(){
                public void run(){
                    synchronized (someObject){
                        garen.hurt();
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThread[i]=t;
        }

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

        System.out.println("最后盖伦的血量为"+garen.hp);
    }
}
