package com.learn.searching.binary;

public class CountOfElement {
    public static void main(String[] args) {
        int k=9;
        int[] arr=new int[]{2, 4, 5, 6, 9, 9, 9, 23};
        int first=firstOccurrence(arr, k);
        if (first!=-1) {
            int last=lastOccurrence(arr, k);
            System.out.println(last-first+1);
        } else {
            System.out.println("Not found element");
        }
    }
    private static int firstOccurrence(int[] arr, int k) {
        int res=-1;
        int start=0, end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]==k) {
                res=mid;
                end=mid-1;
            } else if (arr[mid]<k) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return res;
    }

    private static int lastOccurrence(int[] arr, int k) {
        int res=-1;
        int start=0, end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]==k) {
                res=mid;
                start=mid+1;
            } else if (arr[mid]<k) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return res;
    }
}
