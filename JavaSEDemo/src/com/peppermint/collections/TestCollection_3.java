package com.peppermint.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class TestCollection_3 {
    public static void main(String[] args) {
        List<Hero> heroes=new ArrayList<>();
        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i));
        }
        System.out.println("-----------------");
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
