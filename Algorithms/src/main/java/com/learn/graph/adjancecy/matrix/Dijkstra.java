package com.learn.graph.adjancecy.matrix;

import com.learn.util.MyReader;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        new Dijkstra().solve();
    }
    int[] predecessor;
    boolean[] visited;
    int[] pathLength;
    int V;
    int E;
    private void solve() {
        MyReader mr =new MyReader();
        V=mr.nextInt();
        E=mr.nextInt();
        predecessor=new int[V];
        pathLength=new int[V];
        visited=new boolean[V];
        int[][] graph=new int[V][V];
        for (int i=0;i<V;i++){
            Arrays.fill(graph[i], 0);
        }
        for (int i=0;i<E;i++){
            int u=mr.nextInt();
            int v=mr.nextInt();
            int w=mr.nextInt();
            graph[u][v]=w;
            graph[v][u]=w;
        }
        Arrays.fill(predecessor, -1);
        Arrays.fill(pathLength, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        int src=mr.nextInt();
        dijkstra(graph, src);

        System.out.println();
        for (int i=0;i<V;i++){
            System.out.println("PathLength of "+i+" from src: "+pathLength[i]);
        }
    }

    private void dijkstra(int[][] graph, int src) {
        pathLength[src]=0;
        while (allNotVisited()){
            int u=findMin();
            visited[u]=true;
            for (int v=0;v<V;v++){
                if (graph[u][v]>0 && !visited[v] && pathLength[v]>(pathLength[u]+graph[u][v])){
                    pathLength[v]=pathLength[u]+graph[u][v];
                    predecessor[v]=u;
                }
            }
        }
    }

    private int findMin() {
        int min=Integer.MAX_VALUE;
        int index=0;
        for (int i=0;i<V;i++){
            if (!visited[i] && min>pathLength[i]){
                min=pathLength[i];
                index=i;
            }
        }
        return index;
    }

    private boolean allNotVisited() {
        for (int i=0;i<V;i++){
            if (!visited[i])
                return true;
        }
        return false;
    }
}

/**
10
15
0 1 1
0 6 1
0 8 1
1 4 1
1 6 1
1 9 1
2 4 1
2 6 1
3 4 1
3 5 1
3 8 1
4 5 1
4 9 1
7 8 1
7 9 1
0
 */