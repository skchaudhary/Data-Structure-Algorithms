package com.learn.string;

import java.util.Arrays;
import java.util.Scanner;

public class LongestISubSequance {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(lis(str));
    }

    private static String lis(String str) {
        int[] dp=new int[str.length()];
        Arrays.fill(dp, 1);
        int end = 0;
        int maxLength=1;
        for (int i=1;i<str.length();i++){
            for (int j=0;j<i;j++){
                if (str.charAt(i)>str.charAt(j) && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    if (maxLength<dp[i]){
                        end=i;
                        maxLength=dp[i];
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        int prev=0;
        for (int i=0;i<end;i++){
            if (str.charAt(end)>str.charAt(i) && dp[end]>dp[i] && prev<dp[i]) {
                sb.append(str.charAt(i));
                prev=dp[i];
            }
        }
        sb.append(str.charAt(end));
        return sb.toString();
    }
}
