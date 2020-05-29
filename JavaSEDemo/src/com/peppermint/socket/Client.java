package com.peppermint.socket;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8889);
            System.out.println(socket);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
