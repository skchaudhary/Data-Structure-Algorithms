package com.studypoint.companies.swiggy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MostVisitedShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n=sc.nextInt();
        solve(6, 5, new int[][]{{3,5},{2,3},{4,5},{1,6},{5,6}});
    }

    static void solve(int n, int m, int[][] arr)
    {
        Map<Integer, Integer> mp=new TreeMap<>();
        for (int i=0;i<m;i++){
            for (int j=arr[i][0];j<=arr[i][1];j++){
                mp.put(j, mp.getOrDefault(j, 0)+1);
            }
        }
        List<Map.Entry<Integer, Integer>> lmap=new ArrayList<>(mp.entrySet());
        Collections.sort(lmap, (e1, e2)-> {
            int k=e2.getValue().compareTo(e1.getValue());
            if(k==0){
                return e1.getKey().compareTo(e2.getKey());
            } else {
                return k;
            }
        });
        System.out.println(lmap.get(0).getKey() + " "+lmap.get(1).getKey() + " " + lmap.get(2).getKey());
    }
}
