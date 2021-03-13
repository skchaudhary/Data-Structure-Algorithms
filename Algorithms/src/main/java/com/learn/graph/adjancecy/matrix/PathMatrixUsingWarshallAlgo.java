package com.learn.graph.adjancecy.matrix;

import com.learn.util.MyReader;

public class PathMatrixUsingWarshallAlgo {
    int n;

    public static void main(String[] args) {
        new PathMatrixUsingWarshallAlgo().solve();
    }

    private void solve() {
        MyReader mr = new MyReader();
        System.out.println("Enter the number of vertex.");
        n = mr.nextInt();
        System.out.println("Enter adjacency Matrix: ");
        int[][] adjMatrix = new int[n][n];
        int[][] pathMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = mr.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMatrix[i][j] = ((adjMatrix[i][j] == 1) || (adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1)) ? 1 : 0;
                }
            }
        }

        System.out.println("Path matrix is:");
        boolean flag=false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j]+" ");
                if (adjMatrix[i][j]==0)
                    flag=true;
            }
            System.out.println();
        }
        if (!flag)
            System.out.println("Graph is strongly connected");
    }
}

/**
 * 0 1 0 1
 * 1 0 1 1
 * 0 0 0 1
 * 1 0 1 0
 **/