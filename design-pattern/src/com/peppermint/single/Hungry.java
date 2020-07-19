package com.peppermint.single;

/**
 * @author Administrator
 */

//饿汉式单例
public class Hungry {
    //可能会造成空间浪费
    private byte[] data1=new byte[2014];

    public Hungry(){
    }

    private final static Hungry HUNGRY=new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }

}
