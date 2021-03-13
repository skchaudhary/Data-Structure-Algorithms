package samsung.samsung_solution;

import java.util.Scanner;

public class AirplaneGame {
	private static Scanner sc;
	private static int[][] array;
	private static int[][] deto;
	private static int maxCoins;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			array = new int[n][5];
			deto=new int[5][5];
			maxCoins=-1;
			
			for(int i=0;i<n;i++){
				for(int j=0;j<5;j++)
					array[i][j]=sc.nextInt();
			}
			for(int i=n-1;i>0;i--){		
				detonate(i);
				findMax(2,0,n);
				unDetonate(i);
			}
			System.out.println(maxCoins);
		}
	}
	
	private static void unDetonate(int row) {
		// TODO Auto-generated method stub
		for(int i=row;i>row-5;i--){
			for(int j=0;j<5;j++){
				if(i>=0 && deto[row-i][j]==2){
					array[i][j]=2;
				}
			}
		}
	}

	private static void detonate(int row) {
		// TODO Auto-generated method stub
		for(int i=row;i>row-5;i--){
			for(int j=0;j<5;j++){
				deto[row-i][j]=0;
				if(i>=0 && array[i][j]==2){
					deto[row-i][j]=2;
					array[i][j]=0;
				}
			}
		}
	}

	private static void findMax(int pos, int coins, int n) {
		// TODO Auto-generated method stub
		if(pos<0 || pos>4 || coins<0)return;
		
		if(array[n-1][pos]==2)coins-=1;
		else if(array[n-1][pos]==1)coins+=1;
		
		if(n==1)
		{
			if(coins>maxCoins)maxCoins=coins;
			return;
		}
		else
		{
			findMax(pos+1, coins, n-1);
			findMax(pos-1, coins, n-1);
			findMax(pos, coins, n-1);
		}
	}

}