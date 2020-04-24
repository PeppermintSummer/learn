package com.peppermint.collections;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String,String> dictionary=new HashMap<>();
        dictionary.put("ad", "物理英雄");
        dictionary.put("ap", "法师英雄");
        dictionary.put("t", "坦克英雄");
        //System.out.println(dictionary.get("t"));

        dictionary.clear();

        HashMap<String,String> map=new HashMap<>();
        map.put("ad", "物理英雄");
        map.put("ap", "法师英雄");
        map.put("t", "坦克英雄");
        System.out.println(map);

        HashMap<String,String> res=new HashMap<>();
        map.forEach((s,v) ->res.put(v,s));
        System.out.println(res);
    }
}
