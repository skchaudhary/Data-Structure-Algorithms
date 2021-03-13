package com.learn.perm_comb;

public class CombinationString
{
    static int count=0;
    public static void main(String[] args) {
        String str="ABCDEF";
        combinationUtil(str, 0, str.length()-1);
        System.out.println("total number of combination: "+count);
    }

    private static void combinationUtil(String str, int start, int end) {
        int r=4;
        char[] data=new char[r];
        combination(str, data, 0, end, 0, r);
    }

    private static void combination(String str, char[] data, int start, int end, int index, int r) {
        if (index==r){
            System.out.println(String.valueOf(data));
            count++;
            return;
        }
        for (int i=start; i<=end && end-i+1>=r-index;i++){
            data[index]=str.charAt(i);
            combination(str, data, i+1, end, index+1, r);
        }
    }
}
