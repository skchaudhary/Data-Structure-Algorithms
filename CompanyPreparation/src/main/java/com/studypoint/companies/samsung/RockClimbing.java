package com.studypoint.companies.samsung;

public class RockClimbing {

	final static int maxSize=50;
	static int matrix[][]=new int[maxSize][maxSize];;
	static int visited_matrix[][]=new int[maxSize][maxSize];;
	static int move[][]={{1, 0},{-1, 0},{0, -1},{0, 1}};;
	static int row, col;
	static boolean prob(int x)
	{
		if (Math.random() % 100 < x)
			return true;
		else
			return false;
	}
	static void init_visited_matrix()
	{
		int i, j;
		for (i = 0; i < maxSize; i++)
		for (j = 0; j < maxSize; j++)
			visited_matrix[i][j] = 0;
	}

	void print_matrix(int m, int n)
	{
		int i, j;
		for (i = 0; i < m; i++)
		{
			for (j = 0; j < n; j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tc = 50;
		int m,n;
		while(tc-->0){
			m = (int) (20 + Math.random() % 30);
			n = (int) (20 + Math.random() % 30);

			//For safety, fill the whole matrix with -1 to start with
			for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = -1;


			//Fill the left corner with 2
			matrix[m - 1][0] = 2;

			//Fill the last line with all 1
			for (int i = 1; i < n; i++)
				matrix[m - 1][i] = 1;

			//Pick a random location and fill it with 3
			int loc_x = (int) (Math.random() % m);
			int loc_y = (int) (Math.random() % n);
			matrix[loc_x][loc_y] = 3;

			//pick a random probability between 40 to 60 to fill with 1
			int p = (int) (40 + Math.random() % 20);

			//fill the rest of the matrix with 1s and 0s with probability p

			for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{
				if (-1 == matrix[i][j])
				{
					if (prob(p))
						matrix[i][j] = 1;
					else
						matrix[i][j] = 0;
				}
			}
			row = m;
			col = n;
			//print_matrix(m,n);
			
			int ans = check_for_level(loc_x, loc_y);
			
			//printf("Row %d Col %d Loc_x %d Loc_y %d\n", m, n, loc_x, loc_y);
			System.out.println(ans);

		}
	}
	private static int check_for_level(int dest_x, int dest_y) {
		// TODO Auto-generated method stub
		int level = 1;
		while (true)
		{
			init_visited_matrix();
			visited_matrix[dest_x][dest_y] = 1;
			if (1 == check_for_last_row(dest_x, dest_y, level))
			{
				return level;
			}
			level++;
		}
	}
	private static int check_for_last_row(int dest_x, int dest_y, int level) {
		// TODO Auto-generated method stub
		if (dest_x == row-1)
			return 1;

		int k, temp_x, temp_y;
		for (k = 0; k < (2 + 2 * level); k++)
		{
			if (k < 4)
			{
				temp_y = dest_y + move[k][1];
				temp_x = dest_x + move[k][0];
			}
			else
			{
				temp_y = dest_y;
				temp_x = dest_x + (k/2)*move[k%2][0];
			}
			if (temp_x >= 0 && temp_y >= 0 && temp_x < row && temp_y < col)
			{
				if (matrix[temp_x][temp_y] == 1 && visited_matrix[temp_x][temp_y] == 0)
				{
					visited_matrix[temp_x][temp_y] = 1;
					if (1 == check_for_last_row(temp_x, temp_y, level))
						return 1;
				}
			}
		}
		return 0;
	}

}
