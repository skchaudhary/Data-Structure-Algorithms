package samsung_solution;

import java.util.Scanner;

public class ShootingBalloon {
	static int[] array;
    static int n;
	private static Scanner sc;
    
    private static int balloon() {
        int[][] tab=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                tab[i][j]=-1;
        
        for(int l=1;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                for(int k=i;k<=j;k++){
                    int left=1;
                    int right=1;
                    if(i!=0)left=array[i-1];
                    if(j!=n-1)right=array[j+1];
                    
                    int before=0;
                    int after=0;
                    if(k!=i) before=tab[i][k-1];
                    if(k!=j) after=tab[k+1][j];
                    
                    if(left==1 && right==1)
			tab[i][j]=Integer.max(left*array[k]*right + before + after, tab[i][j]);
                    else 
			tab[i][j]=Integer.max(left*right + before + after, tab[i][j]);
                }
            }
        }
        
        return tab[0][n-1];
    }
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            n=sc.nextInt();
            array=new int[n];
            for(int i=0;i<n;i++)
                array[i]=sc.nextInt();
            int res=balloon();
            System.out.println("# "+res);
        }
    }
}

/*
Test cases:
----------
5
4
1 2 3 4
5
3 10 1 2 5
7
12 48 28 21 67 75 85
8
245 108 162 400 274 358 366 166
10
866 919 840 944 761 895 701 912 848 799

output
------
#1 20
#2 100
#3 16057
#4 561630
#5 6455522

*/
