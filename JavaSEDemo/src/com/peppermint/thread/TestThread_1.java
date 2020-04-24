package com.peppermint.thread;

public class TestThread_1 {
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

//        while (!teemo.isDead()) {
//            garen.attackHero(teemo);
//        }

        //继承Thread类
//        KillThread killThread1=new KillThread(garen, teemo);
//        killThread1.start();
//        KillThread killThread2=new KillThread(bh, leesin);
//        killThread2.start();

        //实现Runnable接口
        //battle1对象实现了Runnable接口，所以有run方法，但是直接调用run方法，并不会启动一个新的线程
        //必须借助一个线程对象的start()方法，才会启动一个新的线程。
        //所以，在创建Thread对象的时候，把battle1作为构造方法的参数传递进去，这个线程启动的时候，就会去执行battle1.run方法了
        Battle battle1=new Battle(garen, teemo);
        new Thread(battle1).start();
        Battle battle2=new Battle(bh, leesin);
        new Thread(battle2).start();

        //匿名类
        Thread t1=new Thread(){
            public void run(){
                while (!teemo.isDead()){
                    garen.attackHero(teemo);
                }
            }
        };
        t1.start();

        Thread t2=new Thread(){
            public void run(){
                while (!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();
    }
}
