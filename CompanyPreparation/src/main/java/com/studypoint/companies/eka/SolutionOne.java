package com.studypoint.companies.eka;

public class SolutionOne {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        isOneAway("abcde", "abcd");  // should return true
        isOneAway("abde", "abcde");  // should return true
        isOneAway("a", "a");  // should return true
        isOneAway("abcdef", "abqdef");  // should return true
        isOneAway("abcdef", "abccef");  // should return true
        isOneAway("abcdef", "abcde");  // should return true
        isOneAway("aaa", "abc");  // should return false
        isOneAway("abcde", "abc");  // should return false
        isOneAway("abc", "abcde");  // should return false
        isOneAway("abc", "bcc");  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        // match first string character with second
        // if changing or deleting satisfied then return true
        int i=0;
        int j=0;
        int count=0;
        while (i<s1.length() && j<s2.length()) {
            if (s1.charAt(i)==s2.charAt(j)){
                i++;j++;
            } else if (s1.charAt(i)!=s2.charAt(j) && s1.length()==s2.length()){
                count++;
                i++;j++;
            } else if (s1.charAt(i)!=s2.charAt(j) && s1.length()<s2.length()) {
                count++;
                j++;
            } else {
                count++;
                i++;
            }

            if (count>1){
                break;
            }
        }
        while (i<s1.length()){
            count++;
            i++;
            if (count>1){
                break;
            }
        }
        while (j<s2.length()){
            count++;
            j++;
            if (count>1){
                break;
            }
        }
        System.out.println(count<=1);
        return count<=1;
    }

}
