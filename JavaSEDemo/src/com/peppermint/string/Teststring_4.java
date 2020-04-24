package com.peppermint.string;

import java.util.Random;
import java.util.UUID;

/**
 * @author Administrator
 */
public class Teststring_4 {
    static Random random=new Random();
    static String temp=new String();

    public static void main(String[] args) {
//        String str1="the";
//
//        StringBuffer sb=new StringBuffer(str1);
//        System.out.println(sb.length()); //3
//        System.out.println(sb.capacity()); //19
//
//        sb.append(" be right");
//        sb.reverse();
//        System.out.println(sb);


        //计算String和StringBuffer性能
        String t1=new String("");
        StringBuffer b1=new StringBuffer("");
        //普通string
        long start_time=System.currentTimeMillis();
        for (int i=0;i<1000;i++){
            t1+=randomString();
        }
        long end_time=System.currentTimeMillis();
        long used_time=end_time-start_time;
        System.out.println("string用时："+used_time);
        //StringBuffer
        start_time=System.currentTimeMillis();
        for (int i=0;i<1000;i++){
            b1=b1.append(randomString());
        }
        end_time=System.currentTimeMillis();
        used_time=end_time-start_time;
        System.out.println("StringBuffer用时："+used_time);

//        String u= UUID.randomUUID().toString();
//        System.out.println(u);
    }

    public static String randomString(){
        for(int j=0;j<10;j++){
            char[] c=new char[10];
            c[j]=(char) (random.nextInt(58)+65); //0~57+65
            temp=String.valueOf(c);
        }
        return temp;
    }
}
