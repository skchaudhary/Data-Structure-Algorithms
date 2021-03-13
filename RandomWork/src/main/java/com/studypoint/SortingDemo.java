package com.studypoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortingDemo {
    public static void main(String[] args) {
        int[] arr=new int[]{2,4,6,1,3,2,6};
        int n=arr.length;
        mergeSort(arr, 0, n-1);
        System.out.println(Arrays.stream(arr).toString());
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l<r) {
            int mid=(l+r)/2;
            mergeSort(nums, l, mid);
            mergeSort(nums, l+1, r);
            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {

        int i=l, j=mid+1;
        int n=r-l+1;
        int k=0;
        int[] tmp=new int[n];

        while (i<=mid && j<=r) {
            if (nums[i]<=nums[j]){
                tmp[k++]=nums[i++];
            } else {
                tmp[k++]=nums[j++];
            }
        }
        while (i<=mid) {
            tmp[k++]=nums[i++];
        }
        while (j<=r) {
            tmp[k++]=nums[j++];
        }

        for (k=0;k<n;k++){
            nums[l+k]=tmp[k];
        }
    }
}
