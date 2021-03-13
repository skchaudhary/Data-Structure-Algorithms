package com.studypoint.companies.samsung;

import java.util.Scanner;

public class Tunnel {

	static Scanner sc;
	static int[][] SB;
	static int minCost, n, h, v;
	static int[] ans;
	static class Machine{
		int C, R, M;
		Machine(int C,int R,int M){
			this.C=C;
			this.R=R;
			this.M=M;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
        	minCost=Integer.MAX_VALUE;
            n=sc.nextInt();
            h=sc.nextInt();
            v=sc.nextInt();
            SB=new int[v+1][h+1];
            ans=new int[v+1];
            for(int i=1;i<=v;i++){
            	for(int j=1;j<=h;j++)
            		SB[i][j]=sc.nextInt();
            }
            Machine m1=new Machine(sc.nextInt(), sc.nextInt(), sc.nextInt());
            Machine m2=new Machine(sc.nextInt(), sc.nextInt(), sc.nextInt());
            findMinCost(m1,m2);
            System.out.println("# "+minCost);
        }
	}
	public static void findMinCost(Machine M1, Machine M2){
		int newCost, min, cost;
		
		for(int i=1;i<=v;i++){
			min=Integer.MAX_VALUE;
			cost=0;
			for(int k1=0;k1<=h;k1++){
				int k2=h-k1;
				for(int j=0;j<=k1;j++)
					cost+=SB[i][j]*M1.C;
				for(int j=h;j>k1;j--)
					cost+=SB[i][j]*M2.C;
				if(k1>k2)
					cost+=(k1-k2-1)*M1.R;
				if(k2>k1)
					cost+=(k2-k1-1)*M2.R;
				if(min>cost)
					min=cost;
				cost=0;
			}
			ans[i]=min;
		}
		
		if(n==1){
			for(int n1=1;n1<=v;n1++){
				if(minCost>=ans[n1])
					minCost=ans[n1];
			}
		}
		
		else if(n==2){
			for(int n1=1;n1<=(v-((n-1)*2));n1++){
				for(int n2=n1+2;n2<=v;n2++){
					newCost=ans[n1]+ans[n2]+(M1.M*M1.M+M2.M*M2.M)*(n2-n1);
					if(minCost>=newCost)
						minCost=newCost;
				}
			}
		}
		else if(n==3){
			for(int n1=1;n1<=(v-((n-1)*2));n1++){
				for(int n2=n1+2;n2<=(v-((n-2)*2));n2++){
					for(int n3=n2+2;n3<=v;n3++){
						newCost=ans[n1]+ans[n2]+ans[n3]+(M1.M*M1.M + M2.M*M2.M)*(n3-n1);
						if(minCost>=newCost)
							minCost=newCost;
					}
				}
			}
		}
		else if(n==4){
			for(int n1=1;n1<=(v-((n-1)*2));n1++){
				for(int n2=n1+2;n2<=(v-((n-2)*2));n2++){
					for(int n3=n2+2;n3<=(v-((n-3)*2));n3++){
						for(int n4=n3+2;n4<=v;n4++){
							newCost=ans[n1]+ans[n2]+ans[n3]+(M1.M*M1.M + M2.M*M2.M)*(n4-n1);
							if(minCost>=newCost)
								minCost=newCost;
						}
					}
				}
			}
		}
		else if(n==5){
			for(int n1=1;n1<=(v-((n-1)*2));n1++){
				for(int n2=n1+2;n2<=(v-((n-2)*2));n2++){
					for(int n3=n2+2;n3<=(v-((n-3)*2));n3++){
						for(int n4=n3+2;n4<=(v-((n-4)*2));n4++){
							for(int n5=n4+2;n5<=v;n5++){
								newCost=ans[n1]+ans[n2]+ans[n3]+(M1.M*M1.M + M2.M*M2.M)*(n4-n1);
								if(minCost>=newCost)
									minCost=newCost;
							}
						}
					}
				}
			}
		}
	}
}
