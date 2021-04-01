package com.learn.searching.binary;

public class FloorOrCeilOfSortedArray {
    public static void main(String[] args) {
        int k=9;
        int[] arr=new int[]{2, 4, 5, 6, 9, 9, 9, 23};
        int first=findFloor(arr,0, arr.length-1, k);
    }

    private static int findFloor(int[] arr, int start, int end, int k) {
        int res=-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]<=k) {
                res=mid;
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return res;
    }

    private static int findCeil(int[] arr, int start, int end, int k) {
        int res=-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]>=k) {
                res=mid;
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return res;
    }
}
