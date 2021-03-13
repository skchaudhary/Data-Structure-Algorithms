package com.learn.string;

import java.util.Arrays;
import java.util.Scanner;

public class LongestISubString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(lis(str));
    }

    private static String lis(String str) {
        int end = 0;
        int maxLength=1;
        for (int i=1;i<str.length();i++){
            int len=1;
            while (i<str.length() && str.charAt(i)>str.charAt(i-1)){
                len++;
                i++;
            }
            if (len>maxLength){
                maxLength=len;
                end=i;
            }
        }
        return str.substring(end-maxLength, end);
    }
}
