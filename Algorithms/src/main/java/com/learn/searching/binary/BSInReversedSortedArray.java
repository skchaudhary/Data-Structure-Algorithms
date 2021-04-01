package com.learn.searching.binary;


import java.util.Arrays;

public class BSInReversedSortedArray {
    public static void main(String[] args) {
        int k=9;
        int[] arr=new int[]{200, 90, 40, 23, 15, 9, 6, 1};
        int element=binary(arr, k);
        if (element!=-1) {
            System.out.println(arr[element]);
        } else {
            System.out.println(element);
        }
    }

    private static int binary(int[] arr, int k) {
        int start=0, end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]==k){
                return mid;
            } else if (arr[mid]<k){
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return -1;
    }
}
