package com.learn.searching.binary;

import java.util.Arrays;

public class FindNearlyElement {
    public static void main(String[] args) {
        int[] input=new int[]{23, 30, 55, 78, 98, 23, 104, 108};
        int[] finderArray=new int[]{13, 45, 67, 98, 58, 69, 101, 98, 109, 103};
        Arrays.sort(finderArray);
        for (int a: input) {
            System.out.println(findNearestElement(finderArray, 0, finderArray.length-1, a));
        }
    }

    private static int findNearestElement(int[] finderArray, int start, int end, int a) {
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (finderArray[mid]==a){
                return finderArray[mid];
            } else if (finderArray[mid]<a) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        if (end<0 || (start < finderArray.length && Math.abs(finderArray[start]-a)<Math.abs(finderArray[end]-a))) {
            return finderArray[start];
        } else {
            return finderArray[end];
        }
    }
}
