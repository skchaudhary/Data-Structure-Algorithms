package com.learn.sorting;

public class HeapSort
{
    public static void main(String[] args) {
        int[] arr=new int[]{2, 15, 12, 9, 8, 10, 1, 7, 11, 5, 13, 4, 14, 0, 3};
        int[] arr1=new int[]{2, 6, 5,3,1};
        int n=arr.length;
        new HeapSort().sort(arr);
        for (int a:arr){
            System.out.print(a + " ");
        }
    }

    private void sort(int[] arr) {
        int n=arr.length;
        for (int i=n/2-1;i>=0;i--){
            heapify(arr, n, i);
        }

        for (int i=n-1;i>0;i--){
            int swap=arr[0];
            arr[0]=arr[i];
            arr[i]=swap;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;

        if (l<n && arr[l]>arr[largest]){
            largest=l;
        }
        if (r<n && arr[r]>arr[largest]){
            largest=r;
        }

        if (largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;

            heapify(arr, n, largest);
        }
    }
}
