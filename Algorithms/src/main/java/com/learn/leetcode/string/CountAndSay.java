package com.learn.leetcode.string;

public class CountAndSay {
    public static void main(String[] args) {
        String[] s=calculate();
        for (int i=1;i<=10;i++) {
            System.out.println(s[i-1]);;
        }
    }
    static String[] calculate(){
        String[] s=new String[30];
        s[0]="1";
        s[1]="11";
        for (int i=2;i<30;i++){
            String s1=s[i-1];
            int j=1;
            int count=1;
            StringBuffer sb=new StringBuffer();
            while(j<=s1.length()){
                while(j<s1.length() && s1.charAt(j)==s1.charAt(j-1)){
                    count++;
                    j++;
                }
                sb.append(count).append(s1.charAt(j-1));
                j++;
                count = 1;
            }
            s[i]=sb.toString();
        }
        return s;
    }
}
