package com.peppermint.thread;

public class TestThread_7 {
    public static void main(String[] args) {
        ThreadPool pool=new ThreadPool();

        for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                }
            };

            pool.add(task);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
