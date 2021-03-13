package com.studypoint.companies.samsung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MrKim {

	static int[][] g;
	static int[] b;
	static Scanner sc;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			List<Point> points=new ArrayList<>();
			int x=sc.nextInt();
			int y=sc.nextInt();
			Point office=new Point(x,y);
			x=sc.nextInt();
			y=sc.nextInt();
			Point home=new Point(x,y);
			points.add(office);
			for(int i=0;i<n;i++){
				x=sc.nextInt();
				y=sc.nextInt();
				points.add(new Point(x,y));
			}
			points.add(home);
			g=new int[n+2][n+2];
			formMatrix(g,n,points);
			for (int i = 0; i < n + 2; i++)
			{
				for (int j = 0; j < n + 2; j++)
				{
					System.out.print(g[i][j]+" ");
				}
				System.out.println();
			}
			result=Integer.MAX_VALUE;
			int a[]=new int[n];
			b=new int[n];
			for(int i=0;i<n;i++)
				a[i]=i+1;
			tsp(a,0,n-1);
			System.out.println(result);
			
			System.out.print("0-->");
			for(int i=0;i<n;i++)
				System.out.print(b[i]+"-->");
			System.out.print(n+1);
		}
	}
	private static void tsp(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		if(l==r){
			int sum=g[0][a[0]];
			for(int i=0;i<a.length-1;i++){
				sum+=g[a[i]][a[i+1]];
			}
			sum+=g[a[a.length-1]][a.length+1];
			if(result>sum){
				result=sum;
				for(int j=0;j<a.length;j++)
					b[j]=a[j];
			}
		}
		else{
			for(int i=l;i<=r;i++){
				swap(a,l,i);
				tsp(a,l+1,r);
				swap(a,l,i);
			}
		}
	}
	private static void swap(int[] a, int l, int i) {
		// TODO Auto-generated method stub
		int tmp=a[l];
		a[l]=a[i];
		a[i]=tmp;
	}
	private static void formMatrix(int[][] g2, int n, List<Point> points) {
		// TODO Auto-generated method stub
		int sx,sy,dx,dy;
		for(int i=0;i<n+2;i++){
			sx=points.get(i).x;
			sy=points.get(i).y;
			for(int j=0;j<n+2;j++){
				if(i==j){
					g[i][j]=0;
					continue;
				}
				dx=points.get(j).x;
				dy=points.get(j).y;
				int diff1=sx>dx?sx-dx:dx-sx;
				int diff2=sy>dy?sy-dy:dy-sy;
				g[i][j]=diff1+diff2;
			}
		}
	}

}
class Point{
	int x,y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

/*
INPUT
3
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
10
39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36

OUTPUT-->
0 110 40 15 160 70 200
110 0 70 95 50 40 90
40 70 0 25 120 30 160
15 95 25 0 145 55 185
160 50 120 145 0 90 40
70 40 30 55 90 0 130
200 90 160 185 40 130 0
#1 200
path: 0-->3-->2-->5-->1-->4-->6

0 128 123 113 129 123 150 4
128 0 19 15 23 5 22 124
123 19 0 18 6 22 27 119
113 15 18 0 22 10 37 109
129 23 6 22 0 26 29 125
123 5 22 10 26 0 27 119
150 22 27 37 29 27 0 146
4 124 119 109 125 119 146 0
#2 304
path: 0-->2-->4-->6-->1-->5-->3-->7

39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96
0 88 78 87 30 80 107 24 59 53 65 110
88 0 56 115 58 60 27 112 79 43 91 94
78 56 0 59 54 58 35 58 23 25 89 38
87 115 59 0 63 107 94 67 36 72 98 23
30 58 54 63 0 50 83 54 35 29 35 86
80 60 58 107 50 0 87 104 71 35 31 90
107 27 35 94 83 87 0 91 58 54 118 73
24 112 58 67 54 104 91 0 39 69 89 90
59 79 23 36 35 71 58 39 0 36 70 51
53 43 25 72 29 35 54 69 36 0 64 57
65 91 89 98 35 31 118 89 70 64 0 121
110 94 38 23 86 90 73 90 51 57 121 0
#3 366
path: 0-->7-->4-->10-->5-->9-->1-->6-->2-->8-->3-->11
*/
