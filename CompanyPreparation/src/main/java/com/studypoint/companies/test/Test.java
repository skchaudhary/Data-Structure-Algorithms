package com.studypoint.companies.test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] s=new Integer[]{10,20};
		Integer[] sum=new Integer[1];
		sum(s, sum);
		System.out.println(sum[0]);
	}
	public static void sum(Integer[] s, Integer[] sum){
		sum[0]=s[0]+s[1];
	}
}
