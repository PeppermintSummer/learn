package com.peppermint.io;

import java.io.*;

public class Copy {
    private static void copyFile(String srcFile,String destFile){
        File src=new File(srcFile);
        File dest=new File(destFile);

        try(BufferedReader br =new BufferedReader(new FileReader(src));
            PrintWriter pw=new PrintWriter(new FileWriter(dest))){
                String line;
                while ((line = br.readLine())!=null){
                    pw.println(line);
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
