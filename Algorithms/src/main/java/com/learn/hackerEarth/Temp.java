package com.learn.hackerEarth;

import java.util.*;

public class Temp {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner sc = new Scanner(System.in);
        // Write your code here
        int t=sc.nextInt();
        while(t-->0){
            char[] s1=sc.next().toCharArray();
            char[] s2=sc.next().toCharArray();
            Arrays.sort(s1);
            Arrays.sort(s2);
            int i=0;
            int j=0;
            int count = 0;
            while(i<s1.length && j<s2.length){
                while (i< s1.length && s1[i]<s2[j]){
                    i++;
                    count++;
                }
                while (j< s2.length && s2[j]<s1[i]){
                    j++;
                    count++;
                }
                while (i< s1.length && j<s2.length && s1[i]==s2[j]){
                    i++;
                    j++;
                }
            }
            while (i< s1.length && j<s2.length && s1[i]<s2[j]){
                i++;
                count++;
            }
            while (i< s1.length && j<s2.length && s2[j]<s1[i]){
                j++;
                count++;
            }
            System.out.println(count);
        }
    }

}
