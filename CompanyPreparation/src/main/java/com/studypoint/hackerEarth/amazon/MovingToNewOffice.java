package com.studypoint.hackerEarth.amazon;

import com.learn.util.MyReader;

public class MovingToNewOffice {
    int x;
    int y;

    void solve() {
        MyReader mr = new MyReader();
        int t = mr.nextInt();

        while (t-- > 0) {
            x = mr.nextInt();
            y = mr.nextInt();
            int n = mr.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++)
                a[i]=mr.nextInt();
            int dp[][] = new int[n][n];
            for (int r = 0; r < n; r++)
                for (int c = r + 1; c < n; c++)
                    dp[r][c] = Integer.MAX_VALUE;
            solve(dp, a, 0, n - 1);
            System.out.println(dp[0][n - 1]);
        }
    }

    private int solve(int[][] dp, int[] a, int l, int r) {
        if (l + 1 >= r)
            return 0;
        int ans = Integer.MAX_VALUE;
        if (dp[l][r] == Integer.MAX_VALUE) {
            for (int m = l + 1; m < r; m++)
                ans = Math.min(solve(dp, a, l, m) + solve(dp, a, m, r) + x * (a[m] - a[l]) + y * (a[r] - a[m]), ans);
            dp[l][r] = ans;
        }
//		System.out.println("" + l + " " + r + " " + dp[l][r]);
        return dp[l][r];
    }

    public static void main(String[] args) throws Exception {
        new MovingToNewOffice().solve();
    }
}