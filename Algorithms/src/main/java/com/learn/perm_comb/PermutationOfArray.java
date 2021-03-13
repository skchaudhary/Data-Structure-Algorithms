package com.learn.perm_comb;

public class PermutationOfArray
{
    static int count=0;
    public static void main(String[] args){
        int[] arr=new int[]{1, 2, 3, 4, 5};

        permutation(arr, 0, arr.length-1);
        System.out.println("total permutation: "+ count);
    }
    static void permutation(int[] arr, int l, int r){
        if (l==r){
            for (int i=0;i<=r;i++){
                System.out.print(arr[i]);
            }
            count++;
            System.out.println();
        }else{
            for (int i=l;i<=r;i++){
                swap(arr, l, i);
                permutation(arr, l+1, r);
                swap(arr, l, i);
            }
        }
    }

    private static void swap(int[] arr, int l, int i) {
        int tmp=arr[i];
        arr[i]=arr[l];
        arr[l]=tmp;
    }
}
