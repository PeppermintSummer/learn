package com.peppermint.socket;

import jdk.internal.util.xml.impl.Input;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TalkClient {
    public static void main(String[] args) {
        Thread t1=new Thread(){
            public void run(){
                try {
                    Socket socket = new Socket("localhost", 8889);
                    OutputStream os=socket.getOutputStream();
                    DataOutputStream dos=new DataOutputStream(os);
                    InputStream is=socket.getInputStream();
                    DataInputStream dis=new DataInputStream(is);
                    Scanner scanner=new Scanner(System.in);
                    while (true){
                        String msg=scanner.nextLine();
                        dos.writeUTF(msg);
                        String resp=dis.readUTF();
                        System.out.println("对方回复:"+resp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }
}
