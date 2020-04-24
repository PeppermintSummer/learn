package com.peppermint.collections;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student("zhangsan","语文",60));
        list.add(new Student("zhangsan","数学",70));
        list.add(new Student("李四","语文",65));
        list.add(new Student("李四","数学",75));

        Student result=null;
        String name=null;
        int total=0;
        for (Student stu : list) {
            if (!stu.name.equals(name)){
                result=new Student();
                total=0;
            }
            total=total+stu.score;
            result.total=total;
            name=stu.name;
        }
        System.out.println(result.total);
    }
}
