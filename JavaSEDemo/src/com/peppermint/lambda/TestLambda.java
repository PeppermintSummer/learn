package com.peppermint.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TestLambda {
    public static void main(String[] args) {
        Random r=new Random();
        List<Hero> heroes=new ArrayList<>();
        for (int i=0;i<10;i++){
            heroes.add(new Hero("hero"+i,r.nextInt(1000),r.nextInt(100)));
        }
        System.out.println("初始化的集合：");
        System.out.println(heroes);
        System.out.println("筛选出hp>100 && damage <50的英雄：");
        filter(heroes);
    }

    public static void filter(List<Hero> heroes){
        for (Hero hero : heroes) {
            if (hero.hp>100 && hero.damage<50){
                System.out.println(hero);
            }
        }
    }
}
