package com.peppermint.thread;

public class TestThread_8 {
    public static void main(String[] args) {
        ThreadPool pool =new ThreadPool();

        int sleep=100;
        while (true){
            pool.add(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(1000);
                sleep = sleep > 100 ? sleep-100 : sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
