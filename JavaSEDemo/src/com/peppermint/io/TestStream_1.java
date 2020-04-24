package com.peppermint.io;

import java.io.*;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class TestStream_1 {
    public static void main(String[] args) {
        File file=new File("e:/Example.txt");
        try {
            byte data[]={88,89};
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //包裹在try当中时，会自动关闭
        try(FileWriter fw=new FileWriter(file)) {
            String data="12345Abc";
            char[] cs=data.toCharArray();
            fw.write(cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
