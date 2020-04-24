package com.peppermint.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Administrator
 */
public class TestFile_2 {
    public static void main(String[] args) {
        File file=new File("e:/Example.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] all = new byte[(int) file.length()];
            fis.read(all);

            for (byte b : all) {
                System.out.println(b);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
