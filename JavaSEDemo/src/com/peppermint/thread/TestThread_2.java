package com.peppermint.thread;

public class TestThread_2 {//常见线程方法
    public static void main(String[] args) {
        Hero garen=new Hero();
        garen.name="盖伦";
        garen.hp=616;
        garen.damage=50;

        Hero teemo=new Hero();
        teemo.name="提莫";
        teemo.hp=300;
        teemo.damage=30;

        Hero bh=new Hero();
        bh.name="女枪";
        bh.hp=500;
        bh.damage=65;

        Hero leesin=new Hero();
        leesin.name="盲僧";
        leesin.hp=455;
        leesin.damage=80;

        //sleep
        Thread t1=new Thread(){
            public void run(){
                int seconds=0;
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("已经运行了"+seconds++ +"秒");
                }
            }
        };
        //守护线程，当一个进程里，都是守护线程时，结束该进程，用来做日志，性能统计等工作
        t1.setDaemon(true);
        t1.start();

        //join
        //主线程的概念，至少会有1个主线程，即main方法开始执行，再后来在主线程中加入该线程
        //主线程会等待该线程结束完毕，才会往下运行
        Thread t2=new Thread(){
            public void run(){
                while (!teemo.isDead()){
                    garen.attackHero(teemo);
                }
            }
        };
        t2.start();
        //代码执行到这里，一直是main()线程在运行
        try {
            //t2线程加入到main线程中来，只有t2线程运行结束，才会继续往下走
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //观察到t2线程运行完成后，才会执行t3线程
        Thread t3=new Thread(){
            public void run(){
                while (!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t3.start();

        //设置线程优先级
//        t2.setPriority(Thread.MAX_PRIORITY);
//        t2.start();

        //设置临时暂停,使得其他线程有更多机会占用cpu资源
        Thread t4=new Thread(){
            public void run(){
                while (!leesin.isDead()){
                    //临时暂停，可以使其他线程占用cpu
                    Thread.yield();
                    bh.attackHero(leesin);
                }
            }
        };
        t4.setPriority(Thread.NORM_PRIORITY);
        t4.start();
    }
}
