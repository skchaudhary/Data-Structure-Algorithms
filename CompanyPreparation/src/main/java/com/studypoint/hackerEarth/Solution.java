package com.studypoint.hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
    final static int mod=1000000007;
    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        MyReader mr =new MyReader();
    }

    int max(int a, int b){
        return a>b?a:b;
    }
    long max(long a, long b){
        return a>b?a:b;
    }
    int min(int a, int b){
        return a<b?a:b;
    }
    long min(long a, long b){
        return a<b?a:b;
    }
    class MyReader
    {
        BufferedReader bf;
        StringTokenizer st;

        public MyReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = bf.readLine();
            } catch (Exception e) {
                System.out.println(e);
            }
            return str;
        }
    }
}
