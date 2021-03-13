package com.learn.perm_comb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationArray
{
    static int count=0;
    public static void main(String[] args) {
        int[] arr=new int[]{1, 2, 3, 4, 5};
        int[] data=new int[4];
        int max = Arrays.stream(arr).max().getAsInt();
        int m=(1<<(int)(Math.log10(max)/Math.log10(2))+1)-1;
        combination(arr, new ArrayList<Integer>(), arr.length, 0, 4);
        System.out.println("total permutation: "+ count);
    }

    private static void combination(int[] arr, List<Integer> data, int n, int start, int r) {
        if (r==0){
            System.out.println(data);
            count++;
            return;
        }
        for (int i=start; i<n; i++){
            data.add(arr[i]);
            combination(arr, data, n,i+1, r-1);
            data.remove(data.size()-1);
        }
    }
}
