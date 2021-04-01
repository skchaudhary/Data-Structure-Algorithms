package com.learn.searching.binary;

public class SearchInNearlySortedArray {
    public static void main(String[] args) {
        int k=9;
        int[] arr=new int[]{2, 4, 5, 6, 9, 9, 9, 23};
        // ith element can be at index i-1 or i+1
        int index=findElement(arr, 0, arr.length-1, k);
        if (index!=-1) {
            System.out.println(arr[index]);
        }
    }

    private static int findElement(int[] arr, int start, int end, int k) {
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]==k) {
                return mid;
            } else if (mid-1>=0 && arr[mid-1]==k) {
                return mid-1;
            } else if (mid+1<=end && arr[mid+1]==k) {
                return mid+1;
            } else if (arr[mid]<k) {
                start=mid+2;
            } else {
                end=mid-1;
            }
        }
        return -1;
    }
}
