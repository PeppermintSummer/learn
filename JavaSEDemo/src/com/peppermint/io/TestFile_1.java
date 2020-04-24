package com.peppermint.io;

import java.io.File;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * @author Administrator
 */
public class TestFile_1 {
    public static void main(String[] args) {
        File file=new File("d:/lolFolder");
        System.out.println("f1的绝对路径："+file.getAbsolutePath());
        boolean exists = file.exists();
        String[] list = file.list();

//        long time=file.lastModified();
//        Date date=new Date(time);
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        String format = sdf.format(date);
//        System.out.println(format);
    }
}
