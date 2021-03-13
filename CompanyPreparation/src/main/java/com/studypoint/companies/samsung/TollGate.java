package com.studypoint.companies.samsung;

import java.util.Scanner;

public class TollGate {

	static Scanner sc;
	static int[] th, tc;
	static int minCost, n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
        	minCost=Integer.MAX_VALUE;
            n=sc.nextInt();
            th=new int[n];
            tc=new int[n];
            for(int i=0;i<n;i++){
            	th[i]=sc.nextInt();
            	tc[i]=sc.nextInt();
            }
            finMinCost(0,0,0,0,0);
            System.out.println("# "+minCost);
        }
	}
	private static void finMinCost(int tp, int tb1, int tb2, int tb3, int currentCost) {
		// TODO Auto-generated method stub
		int sum=tb1+tb2+tb3;
		if(currentCost>minCost)
			return;
		
		if(tp==n-1){
			if(sum<th[tp])
				currentCost+=tc[tp];
			if(minCost>currentCost)
				minCost=currentCost;
			return;
		}
		finMinCost(tp+1, tb1, tb2, tb3, tc[tp]+currentCost);
		finMinCost(tp+1, tb1+th[tp], tb2, tb3, 2*tc[tp]+currentCost);
		
		if(sum>=th[tp]){
			if(th[tp]>tb2+tb3)
				tb1=sum-th[tp];
			if(th[tp]>tb3)
				tb2=th[tp]-tb3>=tb2?0:tb2-th[tp]+tb3;
			
			finMinCost(tp+1, 0, tb1, tb2, currentCost);
		}
	}

}
/**
 * 
 * Problem:
Need to reach from first node to last node, with minimum cost
 
For every node, 3 possibilities:
    1. Pass: same as cost
    2. Hire: Two times of given cost
    3. Battle: Free 
 
Once 'Hire'd, 'Battle' can be applied for max 3 nodes. 
Also that, the hired 'value' (value in sample input) should be available for Battle. 
 
Output for below sample input
150 3000 2370 4721 8231
 
Sample input:
5 //test cases
7 //nodes
10 100 //value and cost
70 5
80 15
20 60
50 90
30 80
10 10

9
600 800
300 400
300 400
1000 400
300 600
100 300
600 300
600 500
1000 300

11
1000 10
700 900
400 500
300 10
900 900
300 10
50 900
50 900
700 900
500 900
50 10

20
896 546
543 216
454 310
408 367
40 602
252 582
954 627
850 234
763 479
232 278
301 538
528 508
936 154
629 443
758 336
432 700
882 256
278 738
517 882
317 136

20
410 610
831 909
675 629
421 774
386 869
544 219
492 414
996 557
499 482
231 285
804 978
304 881
489 911
75 315
927 648
252 914
330 396
937 133
495 882
813 717
 * **/
