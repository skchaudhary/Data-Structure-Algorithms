package com.learn.tree;

import com.learn.util.MyReader;

public class UniqueBSTFirst
{
    public static void main(String[] args) {
        MyReader mr = new MyReader();
        System.out.println("Enter number of node to find number of BST: ");
        int n = mr.nextInt();
        System.out.println(findNumberOfBST(n));
    }

    private static int findNumberOfBST(int n)
    {
        int[] G=new int[n+1];
        G[0]=G[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                G[i]+=G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}
