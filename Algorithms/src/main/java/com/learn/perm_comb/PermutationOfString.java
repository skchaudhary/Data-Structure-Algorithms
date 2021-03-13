package com.learn.perm_comb;

public class PermutationOfString
{
    static int count=0;
    public static void main(String[] args){
        String str="ABCDEF";
        permutation(str, 0, str.length()-1);
        System.out.println("total number of permutation: "+count);
    }
    static void permutation(String str, int l, int r){
        if(l==r){
            System.out.println(str);
            count++;
        }else{
            for(int i=l; i<=r; i++){
                str=swap(str, l, i);
                permutation(str, l+1, r);
                str=swap(str, l, i);
            }
        }
    }
    static String swap(String str, int l, int i){
        char[] ch=str.toCharArray();
        char tmp=ch[l];
        ch[l]=ch[i];
        ch[i]=tmp;
        return String.valueOf(ch);
    }
}
