package com.peppermint.lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestAggregate {
    public static void main(String[] args) {
        Random r=new Random();
        List<Hero> heroes=new ArrayList<>();
        for(int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i,r.nextInt(1000),r.nextInt(100)));
        }
        //管道源是集合
        //聚合操作
        /**
         * filter匹配
         * distinct去重
         * sorted自然排序
         * sorted(comparator<T>)指定排序
         * limit保留
         * skip忽略
         */
        heroes.stream()
                .forEach(h-> System.out.println(h.name));

        //管道源是数组
        Hero[] hs=heroes.toArray(new Hero[heroes.size()]);
        Arrays.stream(hs)
                .forEach(h-> System.out.println(h.name));
    }
}
