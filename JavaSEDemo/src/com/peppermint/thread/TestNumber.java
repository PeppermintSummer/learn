package com.peppermint.thread;

import java.util.concurrent.ThreadLocalRandom;

public class TestNumber {
    public static void main(String[] args) {
        Number n=new Number();

        Thread t1=new Thread(){
          public void run(){
              n.inc();
              System.out.println(n.a);
          }
        };
        t1.start();

        Thread t2=new Thread(){
            public void run(){
                n.inc();
                System.out.println(n.a);
            }
        };
        t2.start();
    }
}
