package com.peppermint.collections;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Node left;
    public Node right;
    public Object value;

    public void add(Object v){
        if (value==null){
            value=v;
        } else {
            if ((Integer)v-((Integer)value) <=0){
                if (left==null){
                    left=new Node();
                }
                left.add(v);
            } else {
                if (right==null){
                    right=new Node();
                }
                right.add(v);
            }
        }
    }

    public List<Object> inorder(){
        List<Object> values=new ArrayList<>();
        if (left!=null){
            values.addAll(left.inorder());
        }
        values.add(value);
        if (right!=null){
            values.addAll(right.inorder());
        }
        return values;
    }

    public static void main(String[] args) {
        int[] random=new int[]{67,8,30,73,10,0,78,81,10,74};
        Node root=new Node();
        for (int number : random) {
            root.add(number);
        }
        System.out.println(root.inorder());
    }
}
