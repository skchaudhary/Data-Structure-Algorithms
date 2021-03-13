package samsung.samsung_solution;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Map;
class Position{
	int pos1,pos2,score;
}
public class FisheryAug10 {

	static int[] visited, fishspot;
	final static int MAX=3;
	static int N;
	static int Ans;
	
	static int[] gate;
	static int[] fishermen;
	
	static void reset_fishspot(int index)
	{
		int i;
		for (i = 1; i <= N; i++)
			if (fishspot[i] == index + 1)
				fishspot[i] = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Ans=Integer.MAX_VALUE;
			N=sc.nextInt();
			gate=new int[MAX];
			fishermen=new int[MAX];
			fishspot=new int[N+1];
			visited=new int[MAX+1];
			for(int i=0;i<MAX;i++){
				gate[i]=sc.nextInt();
				fishermen[i]=sc.nextInt();
			}
			
			findSolution();
			System.out.println(Ans);
		}
	}

	private static void findSolution() {
		int sum = 0;
		int[][] pos=new int[MAX][2];
		int[] npos=new int[MAX];
		int[] score=new int[MAX];
		int i, j;

		for (int index1 = 0; index1 < MAX; index1++)
		{
			sum = 0;
			visited[index1] = 1;
			npos[index1] = calculate_distance(index1, pos, score);
			sum += score[index1];
			for (i = 0; i < npos[index1]; i++)
			{
				fishspot[pos[index1][i]] = index1+1;
				for (int index2 = 0; index2 < MAX; index2++)
				{
					if (visited[index2] == 0)
					{
						visited[index2] = 1;
						npos[index2] = calculate_distance(index2, pos, score);
						sum += score[index2];
						for (j = 0; j < npos[index2]; j++)
						{
							fishspot[pos[index2][i]] = index2+1;
							for (int index3 = 0; index3 < MAX; index3++)
							{
								if (visited[index3] == 0)
								{
									visited[index3] = 1;
									npos[index3] = calculate_distance(index3, pos, score);
									sum += score[index3];
									if (sum < Ans)
										Ans = sum;
									sum -= score[index3];
									visited[index3] = 0;
									reset_fishspot(index3);
								}

							}
							fishspot[pos[index2][i]] = 0;
						}
						sum -= score[index2];
						visited[index2] = 0;
						reset_fishspot(index2);
					}
				}
				fishspot[pos[index1][i]] = 0;
			}
			sum -= score[index1];
			visited[index1] = 0;
			reset_fishspot(index1);
		}
	}

	private static int calculate_distance(int index, int[][] pos, int[] score) {
		int sum = 0, left_min = 999999, right_min = 999999, left, right, npos = 0;
		pos[index][0] = pos[index][1] = score[index] = 0;

		left = right = gate[index];

		// Allot spots to all fishermen except last based on minimum distance
		for (int i = 1; i < fishermen[index]; i++)
		{
			if (fishspot[gate[index]] == 0)
			{
				sum++;
				fishspot[gate[index]] = index + 1;
			}
			else
			{
				left_min = right_min = 999999;

				while ((left > 0) && (fishspot[left] > 0))
					left--;

				while ((right <= N) && (fishspot[right] > 0))
					right++;

				if ((left > 0) && (fishspot[left] == 0))
					left_min = gate[index] - left + 1;

				if ((right <= N) && (fishspot[right] == 0))
					right_min = right - gate[index] + 1;

				if (right_min == left_min)
				{
					// Place 2 fishermen, if avaiable
					if ((fishermen[index] - i) > 2)
					{
						fishspot[left] = fishspot[right] = index + 1;
						sum += (2 * left_min);
						i++;

						// If all fishermen are alloted spots
						if (i == fishermen[index])
						{
							npos = 1;
							score[index] = sum;
							return npos;
						}
					}
					else
					{
						sum += left_min;
						fishspot[left] = index + 1;
					}
				}
				else if (left_min < right_min)
				{
					sum += left_min;
					fishspot[left] = index + 1;
				}
				else if (right_min < left_min)
				{
					sum += right_min;
					fishspot[right] = index + 1;
				}
			}
		}

		left_min = right_min = 99999;

		// Allot spot to last fishermen 
		while ((left > 0) && (fishspot[left] > 0))
			left--;

		if ((left > 0) && (fishspot[left] == 0))
			left_min = gate[index] - left + 1;

		while ((right <= N) && (fishspot[right] > 0))
			right++;

		if ((right <= N) && (fishspot[right] == 0))
			right_min = right - gate[index] + 1;

		if (left_min == right_min)
		{
			npos = 2;
			pos[index][0] = left;
			pos[index][1] = right;
			score[index] = sum + left_min;
		}
		else if (left_min > right_min)
		{
			npos = 1;
			score[index] = sum + right_min;
			fishspot[right] = index + 1;
		}
		else if (left_min < right_min)
		{
			npos = 1;
			score[index] = sum + left_min;
			fishspot[left] = index + 1;
		}

		return npos;
	}
}


/*
 * 
5
10
4 5
6 2
10 2
10
8 5
9 1
10 2
24
15 3
20 4
23 7
39
17 8
30 5
31 9
60
57 12
31 19
38 16
*
*
#1 18
#2 25
#3 57
#4 86
#5 339
*/
