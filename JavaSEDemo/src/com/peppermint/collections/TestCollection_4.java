package com.peppermint.collections;

import java.util.LinkedList;

/**
 * @author Administrator
 */
public class TestCollection_4 {
    public static void main(String[] args) {
        LinkedList<Hero> ll=new LinkedList<>();
        ll.addLast(new Hero("hero1"));
        ll.addFirst(new Hero("hero2"));
        ll.addLast(new Hero("hero3"));
        System.out.println(ll);

        Hero last = ll.getLast();
        Hero first = ll.getFirst();
        Hero hero = ll.get(1);
        ll.removeLast();

    }
}
