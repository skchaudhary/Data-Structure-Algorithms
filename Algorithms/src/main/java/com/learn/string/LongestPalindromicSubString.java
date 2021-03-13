package com.learn.string;

import java.util.Scanner;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(lpss(str));
    }

    private static String lpss(String str) {
        int len=str.length();
        int low, high;
        int maxLength=1;
        int start=0;
        for (int i=1;i<len;i++){
            low = i-1;
            high=i;
            while (low>=0 && high<len && str.charAt(low)==str.charAt(high)){
                if (high-low+1>maxLength){
                    start=low;
                    maxLength=high-low+1;
                }
                low--;
                high++;
            }
            low = i-1;
            high=i+1;
            while (low>=0 && high<len && str.charAt(low)==str.charAt(high)){
                if (high-low+1>maxLength){
                    start=low;
                    maxLength=high-low+1;
                }
                low--;
                high++;
            }
        }
        System.out.println("MaxLength: " + maxLength);
        return str.substring(start, start+maxLength);
    }


    private static int lpss2(String str) {
        int n=str.length();
        int[][] dp=new int[n][n];
        for (int k=0;k<n;k++)
            dp[k][k]=1;

        for (int cl=2;cl<=n;cl++){
            for (int i=0;i<n-cl+1;i++){
                int j=cl+i-1;
                if (str.charAt(i) == str.charAt(j) && cl==2)
                    dp[i][j]=2;
                else if (str.charAt(i) == str.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
