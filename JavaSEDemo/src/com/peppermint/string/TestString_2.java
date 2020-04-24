package com.peppermint.string;

public class TestString_2 {
    public static void main(String[] args) {
        String sentence="你好,哈屁狗,呆瓜";
        char c=sentence.charAt(0);
        System.out.println(c);

        char[] cs=sentence.toCharArray();
        System.out.println(sentence.length()==cs.length);

        String subString=sentence.substring(1);
        System.out.println(subString);

        String[] subSentences =sentence.split(",");
        for (String subSentence : subSentences) {
            System.out.println(subSentence);
        }
//        System.out.println(subSentences[0]);

        String s="peter pipe picked a peck of peppers";
        String[] split = s.split(" ");
        int count=0;
        for (int i=0; i<split.length; i++){
            String s1=split[i].charAt(0)+"";
            if (s1.equals("p")|| s1.equals("P")){
                count++;
            }
        }
        System.out.println(count); //5
    }
}
