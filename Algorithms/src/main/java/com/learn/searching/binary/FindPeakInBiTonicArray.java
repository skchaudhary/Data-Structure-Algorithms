package com.learn.searching.binary;

import java.util.Arrays;

public class FindPeakInBiTonicArray {
    public static void main(String[] args) {
        int[] arr=new int[]{2, 4, 9, 23, 5, 3};
        int index=findPeak(arr, 0, arr.length-1);
        System.out.println(arr[index]);
    }

    private static int findPeak(int[] arr, int start, int end) {
        int n=arr.length;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (mid>0 && mid<n-1) {
                if (arr[mid] > arr[mid-1] && arr[mid]>arr[mid+1]) {
                    return mid;
                } else if (arr[mid]<=arr[mid+1]){
                    start=mid+1;
                } else {
                    end=mid-1;
                }
            } else if (mid==0) {
                if (arr[0]>arr[1]){
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (arr[n-1]>arr[n-2]) {
                    return n-1;
                } else {
                    return n-2;
                }
            }
        }
        return 0;
    }
}
