package com.peppermint.gui;

import javax.swing.*;

public class TestGUI_1 {
    public static void main(String[] args) {
        JFrame f=new JFrame("LOL");
        f.setSize(400, 300);
        f.setLocation(200,200);
        f.setLayout(null);

        JButton b=new JButton("秒杀它");
        b.setBounds(50, 50, 280, 30);
        f.add(b);



        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
