package com.peppermint.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate_2 {
    public static void main(String[] args) {
        //日期转字符串
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=new Date();
        String str=sdf.format(date);
        System.out.println("当前时间进行格式输出后：\n"+str);

        //字符串转日期
        String str2="2020-2-2 12:32";

        try {
            Date d = sdf.parse(str2);
            System.out.println(d.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
