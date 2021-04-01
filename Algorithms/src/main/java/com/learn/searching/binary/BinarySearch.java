package com.learn.searching.binary;


import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int k=9;
        int[] arr=new int[]{2, 9, 4, 23, 5, 6};
        Arrays.sort(arr);
        int element=binary(arr, 0, arr.length-1, k);
        if (element!=-1) {
            System.out.println(arr[element]);
        } else {
            System.out.println(element);
        }
    }

    private static int binary(int[] arr, int start, int end, int k) {
        while (start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]==k){
                return mid;
            } else if (arr[mid]<k){
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return -1;
    }
}
