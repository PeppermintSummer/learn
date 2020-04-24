package com.peppermint.string;

/**
 * @author Administrator
 */
public class TestChar {
    public static void main(String[] args) {
        char c1='a';
        char c2='b';
        char c3='哈';
        //char c4='ab'; 只能放一个字符

        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isDigit('1'));
        System.out.println(Character.isUpperCase('a'));
        System.out.println(Character.toUpperCase('a'));

    }
}
