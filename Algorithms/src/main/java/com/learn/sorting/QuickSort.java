package com.learn.sorting;

public class QuickSort
{
    public static void main(String[] args) {
        int[] arr=new int[]{2, 15, 12, 9, 8, 10, 1, 7, 11, 5, 13, 4, 14, 0, 3};
        int n=arr.length;

        quickSort(arr, 0, n-1);

        for (int a:arr)
            System.out.print(a+" ");
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l>=r)
            return;

        int pivloc=partition(arr, l, r);
        quickSort(arr, l, pivloc-1);
        quickSort(arr, pivloc+1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int i=l+1;
        int j=r;
        int pivot=arr[l];

        while (i<=j){
            while ((arr[i]<pivot) && i<r)
                i++;
            while (arr[j]>pivot)
                j--;

            if (i<j){
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                i++;
                j--;
            }
            else
                i++;
        }
        arr[l]=arr[j];
        arr[j]=pivot;
        return j;
    }
}
