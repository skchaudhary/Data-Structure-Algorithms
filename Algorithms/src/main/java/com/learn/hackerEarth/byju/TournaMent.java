package com.learn.hackerEarth.byju;

import com.learn.util.MyReader;

import java.util.Arrays;

public class TournaMent
{
    public static void main(String[] args) {
        MyReader mr=new MyReader();
        int t=mr.nextInt();
        while (t-->0){
            int N=mr.nextInt();
            char[] c1=mr.next().substring(0, N).toCharArray();
            char[] c2=mr.next().toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            int count = findDrawMatches(c1, c2);
            System.out.println(count);
        }
    }

    private static int findDrawMatches(char[] c1, char[] c2) {
        int count=0;
        int i=0;
        int j=0;
        while (i<c1.length && j<c2.length){
            while (i<c1.length && j<c2.length && c1[i]==c2[j]){
                count++;
                i++;
                j++;
            }
            while (i<c1.length && j<c2.length && c1[i]<c2[j]){
                i++;
            }
            while (i<c1.length && j<c2.length && c1[i]>c2[j]){
                j++;
            }
        }
        return count;
    }
}
/**
 * byju1.txt has the description
 */