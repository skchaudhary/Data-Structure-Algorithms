package com.learn.leetcode.arraydp;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().encode(107));
    }
    public String encode(int num) {
        if(num<=0){
            return "";
        }

        int i=0;
        while((int)Math.pow(2, i)-1<=num){
            i++;
        }
        int start=(int)Math.pow(2, i-1)-1;
        num=num-start;
        StringBuffer sb=new StringBuffer();
        while(num!=0){
            sb.append(num%2);
            num=num/2;
        }
        if (sb.length()<i-1){
            int c=i-1-sb.length();
            while (c!=0) {
                sb.append("0");
                c--;
            }
        }
        return sb.reverse().toString();
    }
}
