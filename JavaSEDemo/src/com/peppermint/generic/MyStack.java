package com.peppermint.generic;

import com.peppermint.collections.Hero;
import com.peppermint.collections.Item;

import java.util.LinkedList;

public class MyStack<T> {
    LinkedList<T> values=new LinkedList<>();
    public void push(T t){
        values.addLast(t);
    }

    public T pull(){
        return values.removeLast();
    }

    public T peek(){
        return values.getLast();
    }

    public static void main(String[] args) {
        MyStack<Hero> heroStack=new MyStack<>();
        heroStack.push(new Hero());
        //不能放Item
//        heroStack.push(new Item());

        MyStack<Item> itemStack=new MyStack<>();
        itemStack.push(new Item());
//        itemStack.push(new Hero());

    }
}
