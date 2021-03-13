package com.learn.leetcode;

public class CustomClass implements Comparable<CustomClass>{
    int value;
    int u;
    int v;
    CustomClass(int value, int u, int v){
        this.value=value;
        this.u=u;
        this.v=v;
    }
    @Override
    public int compareTo(CustomClass cc) {
        if (this.value<cc.value){
            return 1;
        } else if(this.value==cc.value){
            return 0;
        }else {
            return -1;
        }
    }
}
