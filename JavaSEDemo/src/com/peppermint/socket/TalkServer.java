package com.peppermint.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TalkServer {
    private static List<String> cannotUnderstand=new ArrayList<>();

    public static void main(String[] args) {
        cannotUnderstand.add("听不懂");
        cannotUnderstand.add("对不起，无法回答你的问题");
        cannotUnderstand.add("再说一遍？");
        cannotUnderstand.add("大声点");
        cannotUnderstand.add("一边去");

        Thread t1=new Thread(){
            public void run(){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("I'm listening........");
                try {
                    ServerSocket serverSocket = new ServerSocket(8889);
                    Socket socket=serverSocket.accept();
                    InputStream is=socket.getInputStream();
                    DataInputStream dis=new DataInputStream(is);
                    OutputStream os=socket.getOutputStream();
                    DataOutputStream dos=new DataOutputStream(os);
                    while (true){
                        String msg=dis.readUTF();
                        System.out.println("对方的消息:"+msg);
                        String sql="select response from dic where receive = ?";
                        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydemo?serverTimezone=UTC",
                                "root", "123456");
                            PreparedStatement statement=connection.prepareStatement(sql);
                        ) {
                            statement.setString(1, msg);
                            boolean answered=false;
//                            ResultSet resultSet=statement.getResultSet();
                            ResultSet resultSet=statement.executeQuery();
                            while (resultSet.next()) {
                                String resp = resultSet.getString("response");
                                answered = true;
                                System.out.println("自动回复：" + resp);
                                dos.writeUTF(resp + "\r");
                            }
                            if (!answered){
                                Collections.shuffle(cannotUnderstand);
                                dos.writeUTF(cannotUnderstand.get(0));
                                System.out.println("自动回复："+cannotUnderstand.get(0));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } ;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        t1.start();
    }
}
