package com.learn.sorting;

public class MergeSort
{
    public static void main(String[] args) {
        int[] arr=new int[]{2, 15, 12, 9, 8, 10, 1, 7, 11, 5, 13, 4, 14, 0, 3};
        int n=arr.length;

        mergeSort(arr, 0, n-1);

        for (int a: arr)
            System.out.print(a+" ");
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l>=r)
            return;
        int mid=(l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        mergeUtil(arr, l, mid, r);
    }

    private static void mergeUtil(int[] arr, int l, int mid, int r) {
        int i=l;
        int j=mid+1;
        //for temporary array
        int k=l;
        int[] tmp=new int[r+1];

        while (i<=mid && j<=r){
            if (arr[i]<=arr[j])
                tmp[k++]=arr[i++];
            else
                tmp[k++]=arr[j++];
        }
        while (i<=mid)
            tmp[k++]=arr[i++];
        while (j<=r)
            tmp[k++]=arr[j++];

        for (i=l;i<=r;i++){
            arr[i]=tmp[i];
        }
    }
}
