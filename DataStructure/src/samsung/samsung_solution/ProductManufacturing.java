package samsung_solution;

import java.util.Scanner;

public class ProductManufacturing {

	static int CPU;
	static int MEM;
	static int BRD;
	static int CPU_COST;
	static int MEM_COST;
	static int N;

	static class Pro {
		int c;
		int m;
		int b;
		int v;

		Pro(int _c, int _m, int _b, int _v) {
			c = _c;
			m = _m;
			b = _b;
			v = _v;
		}
	}

	static Pro[] products = new Pro[8];

	static int[] MAXNUM = new int[8];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long time = System.currentTimeMillis();
			CPU = sc.nextInt();
			MEM = sc.nextInt();
			BRD = sc.nextInt();
			CPU_COST = sc.nextInt();
			MEM_COST = sc.nextInt();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				products[i] = new Pro(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
				MAXNUM[i] = findMax(products[i]);
			}

			int MAX = Integer.MIN_VALUE;
			// The Brute force approach

			for (int i = 0; i < N; i++) {//for loop 1 for 1st product out of 3 choosen products
				for (int j = 0; j < N; j++) {//for loop 2 for 1st product out of 3 choosen products
					for (int k = 0; k < N; k++) {//for loop 3 for 1st product out of 3 choosen products
						int[] remaining = { CPU, MEM, BRD };
						for (int x = 0; x <= MAXNUM[i]; x++) {//inner loop to cover by taking product-1 out of choosen products from 0 to MAX possible if we take only this product
							if (!decrese(remaining, products[i], x)) {
								break;
							}
							int y = 0;
							for (; y <= MAXNUM[j]; y++) {//inner loop to cover by taking product-2 out of choosen products from 0 to MAX possible if we take only this product
								if (!decrese(remaining, products[j], y)) {
									y++;
									break;
								}
								int z = 0;
								for (; z <= MAXNUM[k]; z++) {//inner loop to cover by taking product-3 out of choosen products from 0 to MAX possible if we take only this product
									if (!decrese(remaining, products[k], z)) {
										z++;
										break;
									}

									int current = x * products[i].v + y * products[j].v + z * products[k].v
											+ remaining[0] * CPU_COST + remaining[1] * MEM_COST;
									MAX = Math.max(MAX, current);
									if (k < 2) {//To cover N<3 cases
										z++;
										break;
									}
								}
								increse(remaining, products[k], z - 1);
								if (j < 1) {//To cover N<3 cases
									y++;
									break;
								}
							}

							increse(remaining, products[j], y - 1);
						}
					}
					if (j >= N - 1)//To cover N<3 cases
						break;
				}

				if (i >= N - 2)//To cover N<3 cases
					break;
			}
			System.out.println("#" + t + " " + MAX);
			System.out.println("#time = " + (double) (System.currentTimeMillis() - time) / 1000);
		}

	}

	private static boolean canProceed(int[] remaining) {
		if (remaining[0] < 0 || remaining[1] < 0 || remaining[2] < 0) {
			return false;
		}
		return true;
	}

	private static void increse(int[] remaining, Pro pro, int x) {
		remaining[0] += pro.c * x;
		remaining[1] += pro.m * x;
		remaining[2] += pro.b * x;
	}

	private static boolean decrese(int[] remaining, Pro pro, int i) {
		if (i != 0) {
			remaining[0] -= pro.c;
			remaining[1] -= pro.m;
			remaining[2] -= pro.b;
		}
		return canProceed(remaining);
	}

	private static int findMax(Pro p) {

		if ((p.c * CPU_COST + p.m * MEM_COST) >= p.v) {
			return 0;
		}
		return Math.min(Math.min(BRD / p.b, CPU / p.c), MEM / p.m);
	}
}

/*
7 
2 2 2 1 1
1
2 2 2 6
5 10 10 1 1       
2
2 1 1 8
1 1 1 6
10 10 10 2 1      
1
1 2 2 3
4 6 4 2 1         
4
2 4 2 9
1 3 1 7
2 1 1 8
1 2 2 6
40 80 60 1 3      
7
3 2 2 56
5 4 2 12
3 5 3 65
1 2 5 78
5 5 2 85
4 2 3 76
5 5 1 48
100 100 100  6 10      
8
3 3 1 74
2 3 1 41
3 2 1 64
2 2 3 68
2 2 2 71
2 3 2 66
2 3 3 84
3 3 1 48 
1
100 100 100 1 1
8
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1


Output:

#1 6
#2 35
#3 30
#4 21
#5 1338
#6 3550
#7 200

Time taken including input reding.
#1  time = 0.002
#2 time = 0.002
#3 time = 0.001
#4 time = 0.003
#5 time = 0.064
#6 time = 0.203
#7 time = 0.001

*/
