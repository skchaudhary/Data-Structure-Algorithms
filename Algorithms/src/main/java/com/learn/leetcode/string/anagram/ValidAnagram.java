package com.learn.leetcode.string.anagram;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("ana", "naa"));
    }
    public boolean isAnagram(String s, String t) {
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null || s.length() != t.length()){
            return false;
        }

        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i]!=0){
                return false;
            }
        }

        return true;
    }
}
