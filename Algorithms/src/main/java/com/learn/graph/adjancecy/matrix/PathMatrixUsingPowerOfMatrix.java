package com.learn.graph.adjancecy.matrix;

import com.learn.util.MyReader;

public class PathMatrixUsingPowerOfMatrix {

    final static int mod = 1000000007;
    int n;//no. of columns
    public static void main(String[] args) {
        new PathMatrixUsingPowerOfMatrix().solve();
    }

    private void solve() {
        MyReader mr = new MyReader();
        System.out.println("Enter the number of vertex.");
        n = mr.nextInt();
        System.out.println("Enter adjacency Matrix: ");
        int[][] adjMatrix = new int[n][n];
        int[][] powerMatrix = new int[n][n];
        int[][] pathMatrix = new int[n][n];
        for (int i=0;i<n;i++){
            String[] input=mr.nextLine().split(" ");
            for (int j=0;j<n;j++){
                adjMatrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int p=1;p<=n;p++){
            copy(adjMatrix, powerMatrix);
            makePathMatrix(adjMatrix, powerMatrix, p);

            System.out.println("Adjacency matrix with the power of "+p);
            display(powerMatrix);

            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    pathMatrix[i][j]=pathMatrix[i][j]+ powerMatrix[i][j];
                }
            }
        }

        System.out.println("PathMatrix for the given adjacency matrix with pathlength");
        display(pathMatrix);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (pathMatrix[i][j]!=0)
                    pathMatrix[i][j]=1;
                else
                    pathMatrix[i][j]=0;

            }
        }
        System.out.println("PathMatrix with 1 and 0");
        display(pathMatrix);
    }

    private void makePathMatrix(int[][] adjMatrix, int[][] powerMatrix, int p) {
        int[][] tmp = new int[n][n];
        for (int k=1;k<p;k++){
            multiply(tmp, adjMatrix, powerMatrix);
            copy(tmp, powerMatrix);
        }
    }

    private void multiply(int[][] tmp, int[][] adjMatrix, int[][] powerMatrix) {
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                tmp[i][j]=0;
                for (int k=0;k<n;k++)
                    tmp[i][j]=tmp[i][j] + powerMatrix[i][k]*adjMatrix[k][j];
            }
        }
    }

    private void copy(int[][] adjMatrix, int[][] powerMatrix) {
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                powerMatrix[i][j]=adjMatrix[i][j];
            }
        }
    }

    private void display(int[][] pathMatrix) {
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(pathMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

/**
 * 0 1 0 1
 * 1 0 1 1
 * 0 0 0 1
 * 1 0 1 0
 **/