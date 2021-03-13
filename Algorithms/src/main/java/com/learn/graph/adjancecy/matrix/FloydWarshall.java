package com.learn.graph.adjancecy.matrix;

import com.learn.util.MyReader;

public class FloydWarshall {
    int[][] graph;
    int[][] D;
    int[][] pred;
    int V;
    public static void main(String[] args) {
        new FloydWarshall().solve();
    }

    private void solve() {
        MyReader mr=new MyReader();
        V=mr.nextInt();
        graph=new int[V][V];
        D=new int[V][V];
        pred=new int[V][V];

        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++) {
                graph[i][j] = mr.nextInt();
            }
        }
        floydWarshall();

        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++){
                //System.out.println("Shortest distance from "+i+" "+j+" is : "+D[i][j]);
                System.out.print(D[i][j]+" ");
            }
            System.out.println();
        }
        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++){
                //System.out.println("Shortest distance from "+i+" "+j+" is : "+D[i][j]);
                System.out.print(pred[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void floydWarshall() {
        for (int i=0;i<V;i++){
            for (int j=0;j<V;j++){
                if (graph[i][j]==0){
                    D[i][j]=9999;
                    pred[i][j]=-1;
                }else {
                    D[i][j]=graph[i][j];
                    pred[i][j]=i;
                }
            }
        }

        for (int k=0;k<V;k++){
            for (int i=0;i<V;i++){
                for (int j=0;j<V;j++){
                    if (D[i][j]>D[i][k]+D[k][j]){
                        D[i][j]=D[i][k]+D[k][j];
                        pred[i][j]=pred[k][j];
                    }
                }
            }
        }
    }
}

/**

 4
 0 1 0 1
 1 0 1 1
 0 0 0 1
 1 0 1 0

 */