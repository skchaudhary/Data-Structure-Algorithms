package com.learn.string;

public class LongestCommonSubSequance {
    public static void main(String[] args) {
        String s1="abcde";
        String s2="ace";
        System.out.println(lcss(s1, s2));
    }
    private static String lcss(String str, String rstr) {
        int m=str.length();
        int n=rstr.length();
        int[][] dp=new int[m+1][n+1];

        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if (i==0 || j==0)
                    dp[i][j]=0;
                else if (str.charAt(i-1)==rstr.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        char[] result=new char[dp[m][n]];
        int i=m;
        int j=n;
        int k=dp[m][n]-1;
        while (i>0 && j>0){
            if (str.charAt(i-1)==rstr.charAt(j-1)){
                result[k--]=str.charAt(i-1);
                i--;
                j--;
            }
            else if (dp[i-1][j]>dp[i][j-1])
                i--;
            else
                j--;
        }
        return String.valueOf(result);
    }
}
