package com.peppermint.number;

import java.util.Scanner;

public class TestNumber_3 {
    public static void main(String[] args) {
        String name="我";
        int kill=8;
        String title="超神";

        System.out.println(name+kill+title);

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入地名");
        String place = scanner.nextLine();
        System.out.println("输入数字");
        int number= scanner.nextInt();

        System.out.println(place+" "+name);
    }
}
