package com.learn.sorting;

public class BubbleSort
{
    public static void main(String[] args) {
        int[] arr=new int[]{2, 15, 12, 9, 8, 10, 1, 7, 11, 5, 13, 4, 14, 0, 3};
        int n=arr.length;

        for (int i=0;i<n;i++){
            for (int j=0;j<n-1-i;j++){
                if (arr[j]>arr[j+1])
                {
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }

        for (int a: arr){
            System.out.print(a+" ");
        }
    }
}
