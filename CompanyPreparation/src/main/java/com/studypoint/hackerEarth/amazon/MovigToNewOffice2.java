package com.studypoint.hackerEarth.amazon;
/* Moving to new office - Ad-optimization team is moving to their new office Safina Towers :) . But the problem is Safina towers
don't have furniture, but you have wood-sheet. You are given a wood-sheet of length L . Since everyone wants to create their desk
in their own style you have to give them some amount of wood. So, you are given N mark-down points (since ad-optimization team
have n members) from that points you have to cut the wood sheet. But the problem is wood-cutter will cost (X * left) + (Y *right)
for cutting the wood (where left and right is the size of the remaining parts of the wood after cutting). For example you want to
cut a wood sheet of length 10 and X=3 and Y=4 and you want to cut at point 7 then left segment size = (7-1) =6 and right segment
size = (10-7) = 3 then wood cutter will cost 3 * 6+4 * 3 = 30 . As Amazonian you have to follow frugality leadership principal,
you want to give wood cutter a minimum amount of money and want to cut wood-sheet from every marking point between 1 to L
(exclusive ) . please note that in all the test case first mark point=1 and last mark point = size of sheet (L). Please output
minimum amount of money needed for every test case.*/
import com.studypoint.hackerEarth.Reader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MovigToNewOffice2
{
    static int mark[] = new int[100], dp[][] = new int[100][100], x, y;
    public static int solve(int beg, int end)
    {
        if(Math.abs(beg - end) <= 1)
            return 0;
        if(dp[beg][end] == -1)
        {
            int i, temp = Integer.MAX_VALUE;
            for(i = beg + 1; i < end; ++i)
                temp = Math.min(temp, x * (mark[i] - mark[beg]) + y * (mark[end] - mark[i]) + solve(beg, i) + solve(i, end));

            dp[beg][end] = temp;
        }
        return dp[beg][end];
    }
    public static void main(String args[]) throws IOException
    {
        Reader rd = new Reader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t, i, n;
        t = rd.nextInt();
        ++t;
        while(--t > 0)
        {
            x = rd.nextInt();
            y = rd.nextInt();
            n = rd.nextInt();
            for(i = 0; i < n; ++i)
            {
                mark[i] = rd.nextInt();
                Arrays.fill(dp[i], i, n, -1);
            }
            bw.write(solve(0, n - 1) + "\n");
        }
        bw.close();
    }
}