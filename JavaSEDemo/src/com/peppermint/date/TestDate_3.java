package com.peppermint.date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator
 */
public class TestDate_3 {
    public static void main(String[] args) {
        //采用单例模式获取日历对象
//        Calendar c= Calendar.getInstance();
//
//        Date date=c.getTime();
//        Date d2=new Date(0);
//        c.setTime(d2);

        //当前日期
        Calendar c=Calendar.getInstance();
        Date now = c.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String current = sdf.format(now);
        System.out.println("当前时间"+ now + "\n"+current);
    }
}
