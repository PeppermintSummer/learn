package com.peppermint.collections;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class TestCollection_1 {
//    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        //数组不可变长，但是arrayList容器可以
        ArrayList heroes=new ArrayList();
        heroes.add(new Hero("Galen"));
        System.out.println(heroes.size());

        //容器的容量capacity会随着对象的增加，自动增长
        heroes.add(new Hero("Teemo"));
        System.out.println(heroes.size());

        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i));
        }

        Hero specialHero = new Hero("special hero");
        heroes.add(specialHero);
        System.out.println(heroes);
        System.out.println(heroes.contains(specialHero));//true
        System.out.println(heroes.get(3));
        heroes.indexOf("");

        heroes.clear();

        //ArrayList实现了接口List
        //接口引用指向子类对象（多态）
        List otherHeroes = new ArrayList();
        otherHeroes.add(new Hero("Joker"));
        System.out.println(otherHeroes.size());
    }
}
