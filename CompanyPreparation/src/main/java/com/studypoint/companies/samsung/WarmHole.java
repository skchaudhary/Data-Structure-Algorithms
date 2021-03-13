package com.studypoint.companies.samsung;

import java.util.Scanner;

public class WarmHole {

	private static Scanner sc;
	static int n;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int x1, y1, x2, y2, wh, dist;
			x1=sc.nextInt(); y1=sc.nextInt();
			x2=sc.nextInt(); y2=sc.nextInt();
			wh=sc.nextInt(); //0<=wh<=5
			n = (2 * wh) + 2;
			int[][] adj=new int[n][n];
			Point[] points = new Point[n]; //creating an array of defined struct type
			points[0] = new Point(x1,y1);
			points[n-1] = new Point(x2,y2);

			int count = 1;
			for (int i = 0; i < wh; ++i)
			{
				x1=sc.nextInt(); y1=sc.nextInt();
				x2=sc.nextInt(); y2=sc.nextInt();
				dist=sc.nextInt();
				points[count] =  new Point(x1,y1);
				count++;
				points[count] = new Point(x2,y2);
				adj[count][count - 1] = dist;
				adj[count - 1][count] = dist;
				count++;
			}
			formMatrix(adj, points, n);
			int res = dijkstra(adj, n);
			System.out.println(res);
		}
	}

	private static int dijkstra(int[][] adj, int n) {
		// TODO Auto-generated method stub
		int[] dist = new int[n];
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; ++i)
		{
			dist[i] = Integer.MAX_VALUE;
			vis[i] = false;
		}
		dist[0] = 0;
		for (int i = 0; i < n - 1; ++i)
		{
			int u = mindistance(dist, vis);
			vis[u] = true;
			for (int v = 0; v < n; ++v)
			{
				if (vis[v] == false && dist[u] != Integer.MAX_VALUE && adj[u][v] != 0 && dist[u] + adj[u][v] < dist[v])
					dist[v] = dist[u] + adj[u][v];
			}
		}
		print(dist);
		return dist[n - 1];
	}

	private static void print(int[] dist) {
		// TODO Auto-generated method stub
		System.out.println("distances from src 0 to vertex:");
		for (int i = 0; i < n; ++i)
		{
			System.out.println(i +"  " + dist[i]);
		}
	}

	private static int mindistance(int[] dist, boolean[] vis) {
		// TODO Auto-generated method stub
		int mnm = Integer.MAX_VALUE;
		int m_index = -1;
		for (int i = 0; i < n; ++i)
		{
			if (vis[i] == false && mnm > dist[i])
			{
				mnm = dist[i];
				m_index = i;
			}
		}
		return m_index;
	}

	private static void formMatrix(int[][] adj, Point[] points, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; ++i)
		{
			int sx = points[i].x;
			int sy = points[i].y;
			for (int j = 0; j < n; ++j)
			{
				if (i == j)
					continue;
				else if (adj[i][j] == 0) //only for other than warm holes
				{
					int dx = points[j].x;
					int dy = points[j].y;
					int diff1 = dx > sx ? dx - sx : sx - dx; //OR......int diff1=abs(dx-sx);
					int diff2 = dy > sy ? dy - sy : sy - dy;
					int wt = diff1 + diff2;
					adj[i][j] = wt;
				}
			}
		}
	}
}

/*
Test cases:
-----------
1 
0 0 60 60          //src and dest
2                  //warm holes
20 20 50 50 10     //entry,exit,cost
1 1 60 60 1000     //entry,exit,cost

1 
0 0 60 60
2
20 20 50 50 10
1 1 60 60 1000

output
------
70
*/
