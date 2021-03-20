package com.studypoint.companies.swiggy;

import java.util.Scanner;

public class InterviewResultDiscussion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(solve(n));
    }

    static int solve(int n)
    {
        int[] dp=new int[n+1];
        for (int i=2;i<=n;i+=2){
            dp[i]=dp[i-2]+i/2;
        }
        return dp[n];
    }

}
