package com.peppermint.thread;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread_10 {
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    //用synchronized🔒实现
    /*public static void main(String[] args) {
        final Object someObject=new Object();

        Thread t1 =new Thread(){
            public void run(){
                try {
                    System.out.println(now()+"t1线程已经运行");
                    System.out.println(now()+this.getName()+"试图占用对象Object");
                    synchronized (someObject){
                        System.out.println(now()+this.getName()+"占用对象someObject");
                        Thread.sleep(1000);
                        System.out.println(now()+this.getName()+"释放对象");
                    }
                    System.out.println("t1线程已经结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.setName("t1");
        t1.start();

        Thread t2=new Thread(){
            public void run(){
                try {
                    System.out.println(now()+"t2线程已经运行！");
                    System.out.println(now()+this.getName()+"试图占用对象someObject");
                    synchronized (someObject){
                        System.out.println(now()+this.getName()+"占用对象someObject");
                        Thread.sleep(1000);
                        System.out.println(now()+this.getName()+"释放对象");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setName("t2");
        t2.start();
    }*/

    public static void log(String msg){
        System.out.println(now()+" "+Thread.currentThread().getName()+" "+msg);
    }

    //Lock是一个接口，与synchronized不同的是，他使用结束之后，就会自动释放掉对someObject的占用
    //lock必须要调用unlock来进行手动释放，为了保证释放的执行，往往会把unlock(),放在finally中执行
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();

        Thread t1=new Thread(){
            public void run(){
                try {
                    log("线程启动！");
                    log("试图占用对象lock");
//                    boolean locked = lock.tryLock(1, TimeUnit.SECONDS);
//                    if (locked){
//
//                    }
                    lock.lock();
                    log("占用对象lock");
                    log("进行5s的业务操作");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2=new Thread(){
            public void run(){
                try {
                    log("线程启动！");
                    log("试图占用对象lock");
                    lock.lock();
                    log("占用对象lock");
                    log("进行5s的业务操作");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t2.setName("t2");
        t2.start();
    }

}
