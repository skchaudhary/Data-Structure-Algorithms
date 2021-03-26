package com.studypoint.companies.altimetrix;

import java.util.ArrayList;
import java.util.List;

public class EmployeeWorkDays {
    public static void main(String[] args) {
        List<String> lsString = findSchedules(56, 8, "???8???");
        for (String s: lsString) {
            System.out.println(s);
        }
    }
    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        // Write your code here
        List<String> stringList = new ArrayList<>();
        char [] pattern1 =pattern.toCharArray();
        for(int i=0;i<pattern1.length;i++){
            if(pattern1[i]!='?') {
                workHours = workHours - (int) pattern1[i] + 48;
            }
        }
        noways(pattern1, 0, dayHours, workHours, stringList);

        return stringList;
    }

    public static void noways(char [] pattern,int curIndex,int maxHour,int haveToWork,List<String> stringList){

        if(haveToWork<=0){
            char patternCopy[] = new char[pattern.length];
            for(int i=0;i<pattern.length;i++){
                if(pattern[i]=='?')
                    patternCopy[i]='0';
                else
                    patternCopy[i]=pattern[i];
            }
            stringList.add(String.valueOf(patternCopy));
            return;
        }
        if(curIndex>=pattern.length)
            return ;
        if(pattern[curIndex]=='?'){
            for(int i=0;i<=maxHour;i++){
                char currentChar = pattern[curIndex];
                pattern[curIndex] = (char)(i+48);
                if(haveToWork-i>=0) {
                    noways(pattern, curIndex + 1, maxHour, haveToWork - i, stringList);
                }
                pattern[curIndex]=currentChar;
            }
        }else{
            noways(pattern,curIndex+1,maxHour,haveToWork,stringList);
        }
    }
}
