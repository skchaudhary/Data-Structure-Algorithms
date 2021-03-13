package samsung_solution;

import java.util.Scanner;

public class RoboFueling {

	static Scanner sc;
	static int[] A, visited;
	static int min, noOfCars;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
        	min=Integer.MAX_VALUE;
        	noOfCars=sc.nextInt();
        	A=new int[noOfCars+2];
        	visited=new int[noOfCars+1];
        	
            for(int i=1;i<=noOfCars;i++){
            	A[i]=sc.nextInt();
            }
            fill(noOfCars,0,2,0,0,0,0);
            if(min==Integer.MAX_VALUE){
            	fill(noOfCars,noOfCars+1,2,noOfCars+1,0,0,1);
            }
            System.out.println("# "+min);
        }
	}
	private static void fill(int n,int count,int rem,int pindex,int cars,int fuel, int g_or_d) {
		int i;
		if(cars==n)
		{
			if(min>count)
			{
				min=count;
			}
			return;
		}
		if(rem<=0) return;
		if(fuel==0 && g_or_d==0)
		{
			int k;
			for(k=1;k<=n;k++)
			{
				if(visited[k]==0 &&A[k]==1)
				{
					visited[k]=1;
					//go to next gas car
					fill(n,count+(k>pindex ? k-pindex:pindex-k),rem-1,k,cars+1,0,0);
					//go to gas station
					fill(n,count+(k>pindex ? k-pindex:pindex-k),2,k,cars+1,1,0);
					//go to diesel station
					fill(n,count+(k>pindex ? k-pindex:pindex-k),2,k,cars+1,2,0);
					visited[k]=0;
				}
			}
		}
		if(fuel==0 && g_or_d==1)
		{
			int k;
			for(k=n;k>=1;k--)
			{
				if(visited[k]==0 && A[k]==2)
				{
					visited[k]=1;
					//go to next gas car
					fill(n,count+(k>pindex ? k-pindex:pindex-k),rem-1,k,cars+1,0,1);
					//go to gas station
					fill(n,count+(k>pindex ? k-pindex:pindex-k),2,k,cars+1,1,1);
					//go to diesel station
					fill(n,count+(k>pindex ? k-pindex:pindex-k),2,k,cars+1,2,1);
					visited[k]=0;
				}
			}
		}
		if(fuel==1)
		{
			//fill gas and recall  
			fill(n,count+pindex,2,0,cars,0,0);
		}
		if(fuel==2)
		{
			//fill diesel and recall
			fill(n,count+((n+1)-pindex),2,n+1,cars,0,1);
		}
	}
}

/*
 * 
2 
5 
1 2 1 2 1
5
2 1 1 2 1

O/P:
#1 12
#2 14
 * */
