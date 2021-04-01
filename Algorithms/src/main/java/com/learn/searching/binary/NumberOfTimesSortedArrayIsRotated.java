package com.learn.searching.binary;

public class NumberOfTimesSortedArrayIsRotated {
    public static void main(String[] args) {
        int k=9;
        int[] arr=new int[]{9, 9, 9, 9, 9, 5, 6, 9};
        int rotation=finMinElementIndex(arr);
        System.out.println(rotation);
    }

    private static int finMinElementIndex(int[] arr) {
        int start=0, end=arr.length-1;
        int n=arr.length;
        while (start<=end){
            int mid=start+(end-start)/2;
            int prev=(mid+n-1)%n;
            int next=(mid+1)%n;
            if (arr[prev]>arr[mid] && arr[next]>=arr[mid]){
                return mid;
            } else if (arr[mid]>arr[end] || (arr[start]==arr[mid] && arr[mid]==arr[end])){
                start=mid+1;
            } else{
                end=mid-1;
            }
        }
        return -1;
    }
}
