package com.peppermint.thread;


import jdk.nashorn.internal.ir.IfNode;

public class Hero {
    public String name;
    public float hp;
    public int damage;

    //直接在方法前加上synchronized所对应的同步对象，就是this，和hurt所达到的效果是一样的
    //这样的话，外部调用的时候  就不要再加synchronized了
    //wait和Notify,他们并不是Thread类上的方法，而是Object上的方法
    //wait():让占用了这个同步对象的线程，临时释放当前的占用，并且等待。所以调用wait是有前提条件的，一定是在synchronized中，否则就会出错
    public synchronized void recover(){
        hp=hp+1;
        this.notify();
    }

    public synchronized void hurt()
//    {
//        synchronized (this){
//            hp=hp-1;
//        }
//    }
    {
        if(hp==1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp=hp-1;
        System.out.println("血量为"+hp);
    }

    public void attackHero(Hero h){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.println(name+"正在攻击"+h.name+","+h.name+"的血条变成了"+h.hp);
        if (h.isDead()){
            System.out.println(h.name+"挂掉了");
        }
    }

    public boolean isDead(){
        return hp<=0?true:false;
    }
}
