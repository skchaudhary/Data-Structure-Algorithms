package com.learn.hackerEarth.byju;

import com.learn.util.MyReader;

import java.util.*;

public class ManHattanMatrix
{
    static MyReader mr;
    public static void main(String[] args) {
        mr=new MyReader();
        int t=mr.nextInt();
        while (t-->0){
            int m=mr.nextInt();
            int n=mr.nextInt();
            int[][] arr=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=mr.nextInt();
                }
            }
            Graph graph=new Graph(m*n);
            makeAdjList(graph, arr, m, n);
            int src=(mr.nextInt()-1)*m+(mr.nextInt()-1);
            findDist(src, graph, m, n);
            int q=mr.nextInt();
            for (int i=0;i<q;i++){
                int dest=(mr.nextInt()-1)*m+(mr.nextInt()-1);
                System.out.println(graph.d[dest]);
            }
        }
    }

    private static void findDist(int src, Graph graph, int m, int n) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[m*n];
        Arrays.fill(visited, false);
        q.offer(src);
        graph.d[src]=0;
        while (!q.isEmpty()){
            int u=q.poll();
            for (int v:graph.adjList[u]){
                if (!visited[v]){
                    visited[v]=true;
                    q.offer(v);
                    graph.d[v]=graph.d[u]+1;
                }
            }
        }
    }

    private static void makeAdjList(Graph graph, int[][] arr, int m, int n) {
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    for(int l=0;l<n;l++){
                        if (k!=i && l!=j){
                           int mh=Math.abs(i-k)+Math.abs(j-l);
                           if (mh==arr[i][j])
                               graph.adjList[i*n+j].add(k*n+l);
                        }
                    }
                }
            }
        }
    }

    static class Graph{
        int v;
        List<Integer>[] adjList;
        int[] d;
        Graph(int v){
            this.v=v;
            d=new int[v];
            adjList=new List[v];
            for (int i=0;i<v;i++){
                d[i]=-1;
                adjList[i]=new ArrayList<>();
            }
        }
    }
}

/**
 * byju1.txt has the description
 */