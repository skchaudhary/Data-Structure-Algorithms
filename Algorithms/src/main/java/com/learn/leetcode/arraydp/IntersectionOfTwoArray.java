package com.learn.leetcode.arraydp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        new IntersectionOfTwoArray().intersect(new int[]{1,2}, new int[]{1,1});
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length){
            int[] tmp = nums1;
            nums1=nums2;
            nums2=tmp;
        }
        Map<Integer, Integer> mp=new HashMap<>();
        int idx1=0, idx2=0;
        while(idx1 < nums1.length) {
            if(mp.containsKey(nums1[idx1])){
                mp.put(nums1[idx1], mp.get(nums1[idx1])+1);
            } else {
                mp.put(nums1[idx1], 1);
            }
            idx1++;
        }
        List<Integer> ls=new ArrayList<>();
        while(idx2 < nums2.length) {
            if(mp.containsKey(nums2[idx2]) && mp.get(nums2[idx2])>0){
                mp.put(nums2[idx2], mp.get(nums2[idx2])-1);
                ls.add(nums2[idx2]);
            }
            idx2++;
        }
        int[] a = new int[ls.size()];
        int idx=0;
        for(int c:ls){
            a[idx++]=c;
        }
        return a;
    }
}
