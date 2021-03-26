package com.studypoint.companies.altimetrix;

import java.util.HashMap;

public class Division {
    public static void main(String[] args) {
        System.out.println(divide(2, 3));
    }

    /*
     * Complete the 'divide' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER dividend
     *  2. INTEGER divisor
     */

    public static String divide(int dividend, int divisor) {
        // Write your code here
        boolean isMinus = !(dividend<0 && divisor<0) && (dividend<0 || divisor<0);

        String res="";
        String result="";
        HashMap<Integer, Integer> map=new HashMap<>();

        dividend = Math.abs(dividend);
        divisor=Math.abs(divisor);

        int rem=dividend%divisor;
        int digit = dividend/divisor;
        if(isMinus) {
            result="-"+digit;
        }else {
            result+=digit;
        }

        while((rem!=0) && (!map.containsKey(rem))) {
            map.put(rem, res.length());
            rem=rem*10;
            int result_part = rem/divisor;
            res+=String.valueOf(result_part);
            rem=rem%divisor;
        }
        if(rem==0 && res.length()!=0){
            result+="." + res;
        } else if (map.containsKey(rem)){
            String repeatedString = res.substring(map.get(rem));
            result+="." + res.substring(0, res.indexOf(repeatedString)) + "(" +repeatedString + ")";
        } else {
            result+=res;
        }

        return result;
    }
}
