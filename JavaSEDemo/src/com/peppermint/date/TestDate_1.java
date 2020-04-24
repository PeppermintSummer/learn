package com.peppermint.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class TestDate_1 {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println("当前时间\n"+date);

        Date d2 = new Date(5000);// 1970 1 1 过了5s
        System.out.println(d2);

        System.out.println("当前时间\n"+date.toString()+"\n"+date.getTime());
        String str="ab"+"cd";


    }
}
