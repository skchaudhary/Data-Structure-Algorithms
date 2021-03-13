package com.learn.leetcode.arraydp;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1};
        int n = new RemoveDuplicatesFromArray().removeDuplicates(nums);
        System.out.println(n);
        for (int i=0;i<n;i++){
            System.out.print(nums[i] + " ");
        }
    }
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int n=nums.length;
        for(int i=0;i<n;i++){
            int a=nums[i];
            int j=i+1;
            while(j<n && nums[j]==a) j++;

            int newSize = shift(nums, i+1, j, n);
            n=newSize;
        }
        return (n);
    }

    public int shift(int[] nums, int left, int right, int n){
        if(left==right){
            return n;
        }
        if(right>=n){
            return left;
        }
        while(right<n){
            nums[left++]=nums[right++];
        }
        return left;
    }
}
