package com.learn.graph.adjancecy.matrix;

import com.learn.util.MyReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prims {
    int V;
    int E;
    public static void main(String[] args) {
        new Prims().solve();
    }

    private void solve() {
        MyReader mr=new MyReader();
        V=mr.nextInt();
        E=mr.nextInt();
        Graph graph=new Graph(V, E);
        for (int i=0;i<E;i++){
            int u=mr.nextInt();
            int v=mr.nextInt();
            int w=mr.nextInt();
            graph.adjList[u].add(new Edge(u, v, w));
            graph.adjList[v].add(new Edge(v, u, w));
        }
        int src=mr.nextInt();
        prims(graph, src);

        for (int i=0;i<V;i++){
            findPath(graph, src, i);
        }
    }

    private void findPath(Graph graph, int src, int i) {
        int dest=i;
        int[] path=new int[V];
        int count=-1;
        int length=0;
        while (dest!=src){
            path[++count]=dest;
            length+=graph.pathLength[dest];
            dest=graph.predecessor[dest];
        }
        System.out.print("Path "+ i +" : "+src);
        for (int j=count;j>=0;j--){
            System.out.print("=>"+path[j]);
        }
        System.out.println("    PathLength: "+length);
    }

    private void prims(Graph graph, int src) {
        Arrays.fill(graph.pathLength, Integer.MAX_VALUE);
        Arrays.fill(graph.predecessor, -1);
        Arrays.fill(graph.visited, false);

        graph.predecessor[src]=-1;
        graph.pathLength[src]=0;
        int u;
        while (allNotVisited(graph)){
            u=findMin(graph);
            graph.visited[u]=true;
            for (Edge e:graph.adjList[u]){
                if (!graph.visited[e.v] && graph.pathLength[e.v]>e.weight){
                    graph.pathLength[e.v]=e.weight;
                    graph.predecessor[e.v]=u;
                }
            }
        }
    }

    private int findMin(Graph graph) {
        int min=Integer.MAX_VALUE;
        int index=-1;
        for (int i=0;i<V;i++){
            if (!graph.visited[i] && min>graph.pathLength[i]){
                min=graph.pathLength[i];
                index=i;
            }
        }
        return index;
    }

    private boolean allNotVisited(Graph graph) {
        for (int i=0;i<V;i++){
            if (!graph.visited[i])
                return true;
        }
        return false;
    }

    class Edge {
        public int src;
        public int v;
        public int weight;
        Edge(int s, int d, int w){
            src=s;
            v=d;
            weight=w;
        }
    }
    class Graph{
        int V;
        int E;
        List<Edge>[] adjList;
        int[] pathLength;
        int[] predecessor;
        boolean[] visited;
        Graph(int v, int e){
            V=v;
            E=e;
            pathLength=new int[V];
            predecessor=new int[V];
            visited=new boolean[V];
            adjList=new ArrayList[V];
            for (int i=0;i<v;i++)
                adjList[i]=new ArrayList<>();
        }
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

6
11
0 1 6
0 2 2
0 3 3
0 4 10
1 3 11
1 5 9
2 3 14
2 4 8
3 4 7
3 5 5
4 5 4
0

 */
