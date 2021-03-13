package com.learn.sorting;

public class InsertionSort
{
    public static void main(String[] args) {
        int[] arr=new int[]{2, 15, 12, 9, 8, 10, 1, 7, 11, 5, 13, 4, 14, 0, 3};
        int n=arr.length;

        for (int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

        for (int a: arr){
            System.out.print(a+" ");
        }
    }
}
