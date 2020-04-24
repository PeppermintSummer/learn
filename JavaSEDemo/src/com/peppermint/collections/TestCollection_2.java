package com.peppermint.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class TestCollection_2 {
    public static void main(String[] args) {
        //对于不适用泛型的容器，可以往里面放英雄，还可以放物品
        List heroes=new ArrayList();
        heroes.add(new Hero("Galen"));
        heroes.add(new Item("刀", 999));
        //那么对象转型就会出现问题
        Hero h1 =(Hero) heroes.get(0);
        Hero h2 =(Hero) heroes.get(1);

        //引入泛型generic
        List<Hero> genericHeroes=new ArrayList<>();
        genericHeroes.add(new Hero("Joker"));
        //其他类型就放不进去
//        genericHeroes.add(new Item("剑", 99));
        //此外，还可以放置Hero的子类

    }
}
