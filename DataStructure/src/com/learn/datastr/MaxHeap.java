package com.learn.datastr;

public class MaxHeap {
    public static void main(String[] args) {
        int[] arr=new int[]{4, 5, 2, 8, 9, 7, 1, 11};
        maxHeap(arr, arr.length);

        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    private static void maxHeap(int[] arr, int n) {
        for (int i=n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
        for (int i=n-1;i>=0;i--){
            int tmp=arr[i];
            arr[i]=arr[0];
            arr[0]=tmp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if (left<n && arr[largest]<arr[left])
            largest = left;
        if (right<n && arr[largest]<arr[right])
            largest=right;
        if (largest!=i){
            int tmp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=tmp;
            heapify(arr, n, largest);
        }
    }
}
