package com.learn.heap;

public class MinHeap {
    public static void main(String[] args) {
        int[] arr=new int[]{4, 5, 2, 8, 9, 7, 1, 11};
        minHeap(arr, arr.length);

        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    private static void minHeap(int[] arr, int n) {
        for (int i = n/2-1;i>=0;i--)
            heapify(arr, n, i);
        for (int i=n-1;i>=0;i--){
            int tmp = arr[0];
            arr[0]=arr[i];
            arr[i]=tmp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if (l<n && arr[smallest]>arr[l])
            smallest=l;
        if (r<n && arr[smallest]>arr[r])
            smallest=r;
        if (smallest!=i){
            int tmp = arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=tmp;
            heapify(arr, n, smallest);
        }
    }
}
