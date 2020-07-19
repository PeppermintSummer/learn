package com.peppermint.single;

/**
 * @author Administrator
 */

//懒汉式
public class LazyMan {
    private LazyMan(){}

    private static LazyMan lazyMan;

    public LazyMan getInstance(){
        if (lazyMan == null) {
            lazyMan=new LazyMan();
        }
        return lazyMan;
    }
}
