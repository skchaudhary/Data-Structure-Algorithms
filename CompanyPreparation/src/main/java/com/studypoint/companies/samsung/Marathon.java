package com.studypoint.companies.samsung;

import java.util.Scanner;

public class Marathon {

	static int finalTime;
	static TimeEnergy[] timeEnergy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			timeEnergy=new TimeEnergy[5];
			int h=sc.nextInt();
			int d=sc.nextInt();
			for(int i=0;i<5;i++){
				timeEnergy[i]=new TimeEnergy();
				
				int min=sc.nextInt();
				int sec=sc.nextInt();
				timeEnergy[i].time=min*60+sec;
				
				timeEnergy[i].energy=sc.nextInt();
			}
			//ComputeByForLoop(h, d);
			System.out.println(finalTime/60+" min "+finalTime%60+" sec");
			finalTime=Integer.MAX_VALUE;
			calculate(0, d, h, 0);
			System.out.println(finalTime/60+" min "+finalTime%60+" sec");
		}
	}
//	private static void ComputeByForLoop(int H, int D) {
//		// TODO Auto-generated method stub
//		
//		finalTime=Integer.MAX_VALUE;
//		for (int m = 0; m <= H  && m <= D; m++)
//	    for (int k = 0; k <= H  && k <= D; k++)
//	    for (int j = 0; j <= H  && j <= D; j++)
//	    for (int i = 0; i <= H  && i <= D; i++)
//	    {
//	        int n = (D - (i + j + k + m));
//	        
//	        int tempTime = i*timeEnergy[0].time + j*timeEnergy[1].time + k*timeEnergy[2].time
//	        		+ m*timeEnergy[3].time + n*timeEnergy[4].time;
//	        int tempEnergy = i*timeEnergy[0].energy + j*timeEnergy[1].energy + k*timeEnergy[2].energy
//	        		+ m*timeEnergy[3].energy + n*timeEnergy[4].energy;
//
//	        if (tempEnergy > H)
//	            continue;
//	        if (finalTime > tempTime)
//	            finalTime = tempTime;
//	    }
//	}
	
	private static void calculate(int curTime, int remDist, int remEnergy, int paceIndex){
		if(curTime>finalTime)
			return;
		if(remEnergy<0)
			return;
		if(remDist<=0){
			if(curTime<finalTime)
				finalTime=curTime;
			return;
		}
		if((remDist*timeEnergy[4].energy)>remEnergy)
			return;
		if (paceIndex == 0)
	        calculate(timeEnergy[0].time + curTime, remDist - 1, remEnergy - timeEnergy[0].energy, 0);
	    if (paceIndex == 1 || paceIndex == 0)
	        calculate(timeEnergy[1].time + curTime, remDist - 1, remEnergy - timeEnergy[1].energy, 1);
	    if (paceIndex == 2 || paceIndex == 0 || paceIndex == 1)
	        calculate(timeEnergy[2].time + curTime, remDist - 1, remEnergy - timeEnergy[2].energy, 2);
	    if (paceIndex == 3 || paceIndex == 0 || paceIndex == 1 || paceIndex == 2)
	        calculate(timeEnergy[3].time + curTime, remDist - 1, remEnergy - timeEnergy[3].energy, 3);
	    if (paceIndex == 4 || paceIndex == 0 || paceIndex == 1 || paceIndex == 2 || paceIndex == 3)
	        calculate(timeEnergy[4].time + curTime, remDist - 1, remEnergy - timeEnergy[4].energy, 4);
	}
}
class TimeEnergy{
	int time;
	int energy;
}

/*
 * INPUT :
Input order :
Total test cases
Total Energy(10) Total Dist(5)
Next 5 lines - input for 5 different paces in min,sec and energy order

eg.
Total_energy Total_distance
Min(pace1) sec(pace1) engery_consumption(pace1)
Min(pace2) sec(pace2) engery_consumption(pace2)
Min(pace3) sec(pace3) engery_consumption(pace3)
Min(pace4) sec(pace4) engery_consumption(pace4)
Min(pace5) sec(pace5) engery_consumption(pace5)

********************


2
10 5
6 19 6
6 29 5
6 39 4
6 49 3
6 59 2
600 40
3 11 20
3 18 16
3 36 14
3 41 13
3 53 12    =>answer : 137min 11sec for 2nd TC
*/
