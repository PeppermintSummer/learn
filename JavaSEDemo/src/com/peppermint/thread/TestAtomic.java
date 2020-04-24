package com.peppermint.thread;

import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    private static int value=0;
    private static AtomicInteger atomicValue=new AtomicInteger();

    public static void main(String[] args) {
//        AtomicInteger atomicInteger=new AtomicInteger();
//
//        //自增自减都是线程安全的
//        int i=atomicInteger.decrementAndGet();
//        int j=atomicInteger.incrementAndGet();
//        int k=atomicInteger.addAndGet(3);

        int number=100000;
        Thread[] threads1=new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t=new Thread(){
                public void run(){
                    value++;
                }
            };
            t.start();
            threads1[i]=t;
        }

        for (Thread thread : threads1) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(number+"个线程进行value++后，value的值变成了"+value);
        Thread[] threads2=new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread t=new Thread(){
                public void run(){
                    atomicValue.incrementAndGet();
                }
            };
            t.start();
            threads2[i]=t;
        }

        for (Thread thread : threads2) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(number+"个线程进行atomicValue.incrementAndGet()后，atomicValue的值变成了"+atomicValue);

//        100000个线程进行value++后，value的值变成了99997
//        100000个线程进行atomicValue.incrementAndGet()后，atomicValue的值变成了100000

    }
}
