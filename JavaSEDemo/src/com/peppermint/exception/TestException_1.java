package com.peppermint.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class TestException_1 {
    public static void main(String[] args) {
        /**
         * 1、throws方法出现在声明上，而throw通常出现在方法体内
         */
        File file=new File("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\rpc.png");
        System.out.println("试图打开文件：");
        try {
            new FileInputStream(file);
            System.out.println("成功打开！");
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        }
        finally {
            System.out.println("一定会执行finally");
        }
    }
}
