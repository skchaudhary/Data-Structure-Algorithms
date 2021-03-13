package samsung.samsung_solution;

import java.util.Scanner;

class Queue{
	int row,col;
	Queue(){
		row=0;
		col=0;
	}
}
public class NewResearch {

	static Scanner sc;
	static int N,C;
	static int[][] location;
	static int[][] region;
	static int Answer;
	static int[][] visited;
	static Queue[] Q;
	static int front=-1, rear=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			N=sc.nextInt();
			C=sc.nextInt();
			location=new int[C][2];
			for(int i=0;i<C;i++){
				location[i][0]=sc.nextInt();
				location[i][1]=sc.nextInt();
			}
			
			region=new int[N+1][N+1];
			for(int i = 1; i <= N; i++)
			{
				for(int j = 1; j <= N; j++)
				{
					region[i][j]=sc.nextInt();
				}
			}
			for(int k = 0; k < C; k++)
			{
				region[location[k][0]][location[k][1]] = 3;
			}
			
			Q=new Queue[1000];
			visited=new int[N+1][N+1];
			Answer = 99999;
			int temp=0;
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= N; j++){
					init();
					temp = 0;
					if(region[i][j] == 1){
						visited[i][j] = 1;
						discover(i, j, 1);
						for(int k = 0; k < C; k++){
							if(temp < visited[location[k][0]][location[k][1]])
								temp = visited[location[k][0]][location[k][1]];
						}
						if(Answer > temp)
							Answer = temp;
					}
					
				}

			}

			// Print the answer to standard output(screen).
			System.out.println(Answer-1);
		}
	}
	
	static void discover(int row, int col, int val)
	{
		int cnt = 0;
		for(int k = 0; k < C; k++)
		{
			if(visited[location[k][0]][location[k][1]] > 0)
				cnt++;
		}
		if(cnt >= C)
			return;

		if((row-1) >= 1 && visited[row-1][col] == 0 && (region[row-1][col] == 1 || region[row-1][col] == 3))
		{
			visited[row-1][col] = val+1;
			++rear;
			Q[rear].row = row-1;
			Q[rear].col = col;
		}
		if((row+1) <= N && visited[row+1][col] == 0 && (region[row+1][col] == 1 || region[row+1][col] == 3))
		{
			visited[row+1][col] = val+1;
			++rear;
			Q[rear].row = row+1;
			Q[rear].col = col;
		}
		if((col-1) >= 1 && visited[row][col-1] == 0 && (region[row][col-1] == 1 || region[row][col-1] == 3))
		{
			visited[row][col-1] = val+1;
			++rear;
			Q[rear].row = row;
			Q[rear].col = col-1;
		}
		if((col+1) <= N && visited[row][col+1] == 0 && (region[row][col+1] == 1 || region[row][col+1] == 3))
		{
			visited[row][col+1] = val+1;
			++rear;
			Q[rear].row = row;
			Q[rear].col = col+1;
		}
		
		while(front<rear)
		{
			++front;
			discover(Q[front].row, Q[front].col, visited[Q[front].row][Q[front].col]);
		}
	}
	
	static void init()
	{
		rear = -1;
		front = -1;
		for(int m = 0; m <= N; m++)
		{
			for(int n = 0; n <= N; n++)
			{
				visited[m][n] = 0;
			}
		}

		for(int m = 0; m <1000; m++)
		{
			Q[m]=new Queue();
		}
	}

}

/*
5
5 2
4 3
3 4
1 1 0 0 0
1 1 0 0 0
1 1 1 1 1
1 1 1 0 1
1 1 1 1 1
8 2
5 6
6 4
1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 0
1 1 0 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
10 3
8 2
5 3
7 1
0 0 0 1 1 1 1 1 1 0
1 1 1 1 1 1 1 1 1 0
1 0 0 1 0 0 0 0 1 0
1 1 1 1 1 1 1 1 1 1
1 1 1 1 0 1 0 0 1 1
1 1 1 1 0 1 0 0 1 1
1 1 1 1 0 1 0 0 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 0 0 1 0 0 1 1
1 1 1 1 1 1 1 1 1 1
15 4
11 15
15 9
1 2
14 3
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 0 1 1 1 1 1 1 1 1 1 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 1 1 1 1 1 1 1 1 1 1 1 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 1 1 1 1 1 1 1 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 0 1 0 0 0 1 0 0 0 0 1 1 0 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
0 0 1 0 0 0 1 1 1 1 1 1 1 0 1
0 0 1 1 1 1 1 1 1 1 1 1 1 1 1
20 4
13 6
20 4
1 2
17 16
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 0 0 0 0 0
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 0 0
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 0 0
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 1 1 1 0 0 1 1
1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 1 1
1 0 1 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0

Output
#1 1
#2 2
#3 2
#4 12
#5 15

*/
