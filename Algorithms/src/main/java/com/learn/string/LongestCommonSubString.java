package com.learn.string;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "aece";
        int[] dp = new int[2];
        System.out.println(lcss(s1, s2));
    }

    private static String lcss(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        int len = 0;
        int end = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (len < dp[i][j]) {
                        len = dp[i][j];
                        end = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        if (len == 0) {
            return "-1";
        }
        return str1.substring(end - len, end);
    }
}
