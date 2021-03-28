package com.learn.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyUtil
{

    public static void main(String[] args) {
        MyFastReader mfr=new MyFastReader();
        int n=mfr.nextInt();
        System.out.println(n);
    }
}

class MyFastReader {

    BufferedReader bf;
    StringTokenizer st;

    public MyFastReader() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(bf.readLine());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = bf.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        return str;
    }
}