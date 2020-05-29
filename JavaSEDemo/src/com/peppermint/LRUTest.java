package com.peppermint;

import java.util.LinkedHashMap;

public class LRUTest {
    public static void main(String[] args) {
        //LRU
        //按照访问顺序进行排序
        LinkedHashMap cache = new LinkedHashMap(16, 0.75f, true);
        cache.put("tom", "tom520");
        cache.put("pony", "pony520");
        cache.put("bob", "bob520");
        cache.put("jack", "jack520");

        cache.forEach((k,v)->System.out.println(k+" "+v));

        cache.get("pony");
        System.out.println("-----------");
        cache.forEach((k,v)-> System.out.println(k+" "+v));

        System.out.println("-----------");
        cache.get("tom");
        cache.forEach((k,v)-> System.out.println(k+" "+v));

    }
}
