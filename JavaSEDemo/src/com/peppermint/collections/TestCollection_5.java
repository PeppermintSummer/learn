package com.peppermint.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollection_5 {
    public static void main(String[] args) {
        //collection是一个接口
        //collections是一个类，容器的工具类
        List<Integer> numbers=new ArrayList<>();
        for (int i=0 ; i<10 ;i++){
            numbers.add(i);
        }
        System.out.println("集合中的数据："+numbers);

        Collections.reverse(numbers);
        System.out.println("翻转之后的数据："+numbers);

        Collections.shuffle(numbers);
        System.out.println("打乱之后的数据："+numbers);

        Collections.sort(numbers);
        System.out.println("排序之后的数据："+numbers);

        Collections.swap(numbers, 0, 5);
        System.out.println("交换之后的数据" +numbers);

        Collections.rotate(numbers, 2);
        System.out.println("把集合中的元素向右滚动2个单位:"+numbers);

        //把非线程安全的List转换为线程安全的List
        List<Integer> synchronizedNumbers= (List<Integer>) Collections.synchronizedList(numbers);

        //传统方式：定义比较函数
        Collections.sort(numbers,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return 1;
            }
        });
        //聚合方式

    }
}
