package com.peppermint.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
            try {
                serverSocket = new ServerSocket(8889);
                System.out.println("我在监听窗口号8889");
                Socket socket = serverSocket.accept();
                System.out.println("有连接"+socket);
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
