package com.peppermint.string;

import javax.jnlp.IntegrationService;
import java.sql.SQLOutput;

/**
 * @author Administrator
 */
public class TestString_3 {
    public static void main(String[] args) {
//        String str1="the light";
//        String str2=new String(str1);
//        System.out.println(str1==str2); //false
//        System.out.println(str1.equalsIgnoreCase(str2)); //true

//        Integer i= new Integer(100);
//        Integer j =new Integer(100);
//        System.out.print(i==j);//false

//        Integer i = new Integer(100);
//        Integer j = 100;
//        System.out.print(i == j);  //false

//        Integer i = 100;
//        Integer j = 100;
//        System.out.print(i == j); //true

//        Integer i = 128;
//        Integer j = 128;
//        System.out.print(i == j); //false,超过了127，数据类型范围-128~127



//        int 变量 与 Integer、 new Integer() 比较时，只要两个的值是相等，则为true
//        Integer i = new Integer(100); //自动拆箱为 int i=100; 此时，相当于两个int的比较
//        int j = 100；
//        System.out.print(i == j); //true
//        Integer i=new Integer(128);
//        int j=128;
//        System.out.println(i==j); //true

        String str1="ab";
        String str2="abc";
        String str3=str1+"c";
        String str4="a"+"b"+"c";
        System.out.println(str2==str3); //false
        System.out.println(str2==str4); //true
    }

}
