package com.peppermint.string;

import java.util.Random;

/**
 * @author Administrator
 */
public class TestString_1 {
    public static void main(String[] args) {
        //string被final修饰，不能被继承

        String hero="盖伦"; //创建一个字符串对象
        String teemo= new String("Teemo"); //创建了2个
        char[] cs=new char[]{'哈','皮','狗'};
        String hero2=new String(cs);

        System.out.println(hero2);

        /**
         *这个地方大大学问，仔细看
         */
        String str1="abc";
        String str2=new String("abc");
        System.out.println(str1==str2); //false
        System.out.println(str1.equals(str2));


        String content="ABCDEFGHIJKLMNOPQRSTUVWHYZ";//创建23个大写字母的字符串
        content+=content.toLowerCase();//把大写字母转换成小写字母，相连接
        content+="0123456789";//连接0~9的数字。
        Random r=new Random();//创建一个随机数对象
        StringBuilder b=new StringBuilder(5);//创建空间大小为5的StringBuilder对象
        for (int i = 0; i <5; i++) {
            char n=content.charAt(r.nextInt(content.length()));//截取一个从0到content.length()之间的字符，循环输出5个不同的字符，追加到一起
            b.append(n);
        }
        System.out.println(b.toString());//转成字符串输出5个字符
    }
}
