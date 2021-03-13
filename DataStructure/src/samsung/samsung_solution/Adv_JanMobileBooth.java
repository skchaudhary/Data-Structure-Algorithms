package samsung.samsung_solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Adv_JanMobileBooth {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int[][] graph=new int[n][n];
			List<A> zeroList=new LinkedList<>();
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					graph[i][j]=sc.nextInt();
					if(graph[i][j]==0)
						zeroList.add(new A(i,j));
				}
			}
				

			solve(graph, zeroList, n);
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					System.out.print(graph[i][j]+" ");
				System.out.println();
			}	
				
		}
	}

	private static void solve(int[][] graph, List<A> zeroList, int n) {
		// TODO Auto-generated method stub
		List<List<A>> l=new ArrayList<>();
		ListIterator<A> li1=zeroList.listIterator();
		List<A> list = new LinkedList<>(zeroList);
		
		Queue<A> q=new LinkedList<>();
		for(A c:list){
			List<A> l1=new ArrayList<>();
			q.offer(c);
			if(!li1.hasNext())
				break;
			while(!q.isEmpty()){
				A a=q.poll();
				List<A> rlist=new ArrayList<>();
				while(li1.hasNext()){
					A b=li1.next();
					if((a.a==b.a && a.b==b.b) || (a.a==b.a && a.b==b.b-1) || (a.a==b.a && a.b==b.b+1) ||
							(a.a==b.a-1 && a.b==b.b) || (a.a==b.a+1 && a.b==b.b)){
						l1.add(b);
						li1.remove();
						q.offer(b);
					}
					else
						rlist.add(b);
				}
				li1=rlist.listIterator();
			}
			if(l1.size()>0)
				l.add(l1);	
		}
		for(List<A> l2:l){
			for(A a: l2)
				System.out.print(graph[a.a][a.b]+" ");
			System.out.println("sanjay");
		}
		for(List<A> l2:l){
			int max=findMax(l2, graph, n);
			for(A a:l2){
				graph[a.a][a.b]=max;
			}
		}
	}

	private static int findMax(List<A> l2, int[][] graph, int n) {
		// TODO Auto-generated method stub
		int max=0;
		for(A a:l2){
			if(a.a>0 && graph[a.a-1][a.b]>max)
				max=graph[a.a-1][a.b];
			if(a.a<n-1 && graph[a.a+1][a.b]>max)
				max=graph[a.a+1][a.b];
			if(a.b>0 && graph[a.a][a.b-1]>max)
				max=graph[a.a][a.b-1];
			if(a.b<n-1 && graph[a.a][a.b+1]>max)
				max=graph[a.a][a.b+1];
		}
		return max;
	}
}
class A{
	public int a,b;
	A(int a, int b){
		this.a=a;
		this.b=b;
	}
}


/*
3
5
5 5 1 4 4
4 0 2 4 2
5 0 0 2 0
5 4 3 0 1
1 3 3 2 1
10
1 3 5 1 4 0 0 4 2 1
1 1 2 1 1 0 5 0 2 1
5 0 2 0 4 4 4 0 1 1
0 2 2 4 0 5 4 2 1 3
1 1 2 2 2 3 3 2 1 1
5 1 1 2 0 3 3 2 2 1
3 1 1 1 0 0 1 2 2 5
3 1 4 1 2 0 4 0 0 5
4 0 3 3 1 3 3 0 0 1
5 0 3 1 4 3 3 1 2 3
20
0 2 1 0 1 3 3 3 3 4 4 1 1 1 4 1 1 4 1 4
0 2 3 5 1 2 3 3 3 3 4 2 1 3 2 2 1 1 1 3
0 2 1 5 1 2 2 2 0 3 2 3 4 2 1 3 3 0 1 1
1 5 4 5 1 2 5 5 5 5 2 5 5 2 0 0 3 3 5 4
1 0 5 5 3 5 3 0 4 5 5 5 1 0 1 1 3 4 0 0
4 5 3 4 4 5 3 3 0 0 3 3 1 3 1 3 2 5 0 0
3 2 0 0 0 3 4 1 1 1 1 3 5 2 1 3 1 4 0 5
2 2 0 2 3 3 3 0 1 5 1 3 5 2 5 3 4 4 0 5
3 4 0 1 1 1 0 4 4 4 4 1 5 0 4 5 3 4 4 4
3 2 0 1 4 4 3 0 0 0 3 5 1 0 1 4 1 3 4 4
0 3 1 1 1 1 1 1 2 2 3 3 1 0 5 4 4 4 4 4
4 2 5 3 4 4 4 1 2 5 5 5 4 1 1 1 4 1 0 5
4 2 5 1 4 2 5 2 0 1 5 2 4 1 4 1 1 0 0 0
1 2 3 0 1 4 2 2 4 1 1 0 4 4 4 5 4 1 0 0
3 2 0 1 1 1 2 1 3 1 0 4 1 4 4 2 4 3 3 0
3 3 5 4 1 1 1 1 3 2 4 4 4 4 4 3 3 3 3 4
4 3 1 1 1 1 1 1 1 3 2 2 0 5 4 4 4 5 0 0
3 3 2 0 5 0 3 3 1 3 2 4 0 4 0 4 4 2 4 4
1 4 4 3 4 5 2 4 4 4 4 4 0 5 0 4 0 3 1 0
5 4 4 5 2 3 3 0 0 5 2 4 3 3 2 3 4 4 5 0

#output
#1: 11
#2: 31
#3: 130
 */