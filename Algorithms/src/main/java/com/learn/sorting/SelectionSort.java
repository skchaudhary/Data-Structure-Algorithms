package com.learn.sorting;

public class SelectionSort
{
    public static void main(String[] args) {
        int[] arr=new int[]{2, 15, 12, 9, 8, 10, 1, 7, 11, 5, 13, 4, 14, 0, 3};
        int n=arr.length;

        for (int i=0;i<n-1;i++){
            int key=i;
            for (int j=i+1;j<n;j++){
                //logic to find smaller number
                if (arr[key]>arr[j])
                    key=j;
            }
            //if smaller number is other than a[i]
            if (key!=i){
                int tmp=arr[i];
                arr[i]=arr[key];
                arr[key]=tmp;
            }
        }
        for (int a:arr) {
            System.out.print(a+" ");
        }
    }
}
