package com.learn.searching.binary;

public class ElementInRotatedSortedArray {
    public static void main(String[] args) {
        int k=9;
        int[] arr=new int[]{2, 4, 5, 6, 9, 9, 9, 23};
        int minIndex=finMinElementIndex(arr, k);
        if (minIndex!=-1) {
            int index=binary(arr, 0, minIndex-1, k);
            if (index!=-1) {
                System.out.println(arr[index]);
            } else {
                index=binary(arr, minIndex, arr.length-1, k);
                if (index!=-1) {
                    System.out.println(arr[index]);
                }
            }
        }else {
            System.out.println("Not found element");
        }
    }

    private static int binary(int[] arr, int start, int end, int k) {
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]==k){
                return mid;
            } else if (arr[mid]<k) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return -1;
    }

    private static int finMinElementIndex(int[] arr, int k) {
        int start=0, end=arr.length;
        int n=arr.length;
        while (start<=end) {
            int mid=start+(end-start)/2;
            int prev=(mid+n-1)%n;
            int next=(mid+1)%n;
            if (arr[mid]>arr[prev] && arr[mid]>=arr[next]){
                return mid;
            } else if (arr[mid]>arr[end] || (arr[start]==arr[mid] && arr[mid]==arr[end])) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return -1;
    }

}
