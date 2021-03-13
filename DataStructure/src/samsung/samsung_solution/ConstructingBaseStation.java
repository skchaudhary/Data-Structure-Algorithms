package samsung.samsung_solution;

import java.util.Scanner;

/**
 * @author SANJAY CHAUDHARY
 *
 */
public class ConstructingBaseStation {

	static int maxCount;
	private static int[][] cells;
	private static int[][] visited;
	private static Scanner sc;
	static int m;
	static int n;
	static int[][] edir;
	static int[][] odir;
	static{
		edir=new int[][]{ { -1, -1, -1, 0, 1, 0 },{ -1, 1, 0, 1, 0, -1 } };
		odir=new int[][]{ { 0, 0, -1, 1, 1, 1 },{ -1, 1, 0, 1, -1, 0 } };
	}
	private static void findMaxScore(int cX, int cY, int count, int curValue) {
		// TODO Auto-generated method stub
		int nX,nY;
		if(count==4){
			if(maxCount<curValue)
				maxCount=curValue;
			return;
		}
		
		for(int i=0;i<6;i++){
			if (cY % 2 == 0){
				nX = cX + edir[0][i];
				nY = cY + edir[1][i];
			}
			else{
				nX = cX + odir[0][i];
				nY = cY + odir[1][i];
			}
			if (isvalid(nX, nY) && visited[nX][nY] == 0){
				visited[nX][nY] = 1;
				findMaxScore(cX, cY, count + 1, curValue + cells[nX][nY]);
				findMaxScore(nX, nY, count + 1, curValue + cells[nX][nY]);
				visited[nX][nY] = 0;
			}
		}
	}
	
	private static boolean isvalid(int nX, int nY) {
		// TODO Auto-generated method stub
		if (nX < 0 || nX >= m || nY < 0 || nY >= n)
			return false;
		return true;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			m=sc.nextInt();
			n=sc.nextInt();
			maxCount=0;
			cells=new int[m][n];
			visited=new int[m][n];
			
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++)
					cells[i][j]=sc.nextInt();
			}
			
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					visited[i][j]=1;
					findMaxScore(i,j,1,cells[i][j]);
					visited[i][j]=0;
				}
			}
			System.out.println(maxCount*maxCount);
		}
	}
}

/*
 * 
6
3 4
150 450 100 320
120 130 160 110
10 60 200 220
1 4
10 20 30 40
3 5
300 410 150 55 370 
120 185 440 190 450 
165 70 95 420 50 
5 5
356 55 41 453 12 
401 506 274 506 379 
360 281 421 311 489 
425 74 276 371 164 
138 528 461 477 470 
3 13
197 51 443 274 47 552 160 96 501 102 469 318 308 
516 128 506 471 381 418 328 517 380 78 569 58 90 
113 238 179 444 541 27 444 62 264 93 245 353 37 
11 7
292 182 586 607 259 190 239 
511 716 425 367 511 462 714 
593 713 231 60 118 442 82 
626 577 579 682 136 176 681 
240 23 410 193 230 729 109 
453 231 287 383 444 578 409 
729 401 408 330 213 574 54 
684 224 75 62 660 472 227 
606 37 473 487 222 185 476 
84 477 158 94 141 484 122 
616 333 302 626 29 99 674
*/
/*
1276900
10000
2250000
3748096
3928324
7236100
*/