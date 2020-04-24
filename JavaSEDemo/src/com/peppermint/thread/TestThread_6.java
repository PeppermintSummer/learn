package com.peppermint.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestThread_6 {
    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = Collections.synchronizedList(list1);

        //死锁
        Hero ahri=new Hero();
        ahri.name="啊狸";
        Hero annie=new Hero();
        annie.name="安妮";

        Thread t1=new Thread(){
            public void run(){
                synchronized (ahri){
                    System.out.println("t1已经占有阿狸");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1试图占有安妮");
                    System.out.println("等待着---");
                    synchronized (annie){
                        System.out.println("do something");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                synchronized (annie){
                    System.out.println("t2已经占有安妮对象");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2试图占有阿狸");
                    System.out.println("t2等待着");
                    synchronized (ahri){
                        System.out.println("do something");
                    }
                }
            }
        };
        t2.start();
    }
}
