package com.studypoint.leetcodeweekly.week231;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class XOROfAllSegments {
    public static void main(String[] args) {
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
    }
    static String isValid(String s) {
        if (s==null || s.length()<=1) {
            return "YES";
        }

        int[] fr=new int[26];
        for(int i=0;i<s.length();i++){
            fr[s.charAt(i)-'a']++;
        }
        Map<Integer, Integer> set = new HashMap<>();
        for(int i=0;i<26;i++) {
            if(fr[i]!=0) {
                set.put(fr[i], set.getOrDefault(fr[i], 0) + 1);
            }
        }
        if (set.size()>2){
            return "NO";
        } else if (set.size()==2) {
            Integer[] arr= set.keySet().toArray(new Integer[2]);
            if(set.get(arr[0])==1 && (arr[0]-1==arr[1] || arr[0]-1==0))
                return "YES";
            else if(set.get(arr[1])==1 && (arr[1]-1==arr[0] || arr[1]-1==0))
                return "YES";
            else
                return "NO";
        } else {
            return "YES";
        }
    }

}
