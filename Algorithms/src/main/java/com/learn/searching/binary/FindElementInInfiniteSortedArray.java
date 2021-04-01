package com.learn.searching.binary;

public class FindElementInInfiniteSortedArray {
    public static void main(String[] args) {
        int k=9;
        int[] arr=new int[]{2, 4, 5, 6, 9, 9, 9, 23};
        int start=0, end=1;
        while (arr[end]<k) {
            start=end;
            end=2*end;
        }

        int first=binary(arr, start, end, k);
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
