package com.peppermint.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThread_4 {
    public static String now(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    }

    public static void main(String[] args) {
        final Object someObject=new Object();

        Thread t1=new Thread(){
            public void run(){
                System.out.println(now()+"t1线程已经运行");
                System.out.println(now()+this.getName()+"试图占有对象");
                synchronized (someObject) {
                    System.out.println(now()+this.getName()+"占有对象");
                    try {
                        Thread.sleep(5000);
                        System.out.println(now()+this.getName()+"释放对象");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(now()+"t1线程结束");
            }
        };
        t1.setName("t1");
        t1.start();

        Thread t2=new Thread(){
            public void run(){
                try {
                    System.out.println(now()+"t2线程已经运行");
                    System.out.println(now()+this.getName()+"试图占有对象");
                    synchronized (someObject){
                        System.out.println(now()+this.getName()+"占有对象");
                        Thread.sleep(5000);
                        System.out.println(now()+this.getName()+"释放对象");
                    }
                    System.out.println(now()+"t2线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setName("t2");
        t2.start();
    }
}
