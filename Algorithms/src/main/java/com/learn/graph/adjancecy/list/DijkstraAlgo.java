package com.learn.graph.adjancecy.list;

import com.learn.util.MyReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraAlgo {
    class Edge{
        int src;
        int dest;
        int weight;
        Edge(int s, int d, int w){
            src=s;
            dest=d;
            weight=w;
        }
    }
    class Graph{
        int[] predecessor;
        boolean[] visited;
        int[] pathLength;
        int V;
        int E;
        List<Edge>[] adjList;
        Graph(int v, int e){
            V=v;
            E=e;
            pathLength=new int[v];
            Arrays.fill(pathLength, Integer.MAX_VALUE);
            visited=new boolean[v];
            Arrays.fill(visited, false);
            predecessor=new int[v];
            Arrays.fill(predecessor, -1);

            adjList=new ArrayList[v];
            for (int i=0;i<v;i++){
                adjList[i]=new ArrayList<>(10);
            }
        }
    }
    public static void main(String[] args) {
        new DijkstraAlgo().solve();
    }
    private void solve() {
        MyReader mr=new MyReader();
        int V=mr.nextInt();
        int E=mr.nextInt();
        Graph graph=new Graph(V, E);
        for (int i=0;i<E;i++){
            int u=mr.nextInt();
            int v=mr.nextInt();
            int w=mr.nextInt();
            Edge edge1=new Edge(u, v, w);
            Edge edge2=new Edge(v, u, w);
            graph.adjList[u].add(edge1);
            graph.adjList[v].add(edge2);
        }
        int src=mr.nextInt();
        dijkstra(graph, src);
        for (int i=0;i<V;i++){
            System.out.println("path of vertex: "+i+"="+graph.pathLength[i]);
        }
    }

    private void dijkstra(Graph graph, int src) {
        graph.pathLength[src]=0;
        graph.predecessor[src]=-1;
        while (allNotVisited(graph)){
            int u=findMin(graph);
            graph.visited[u]=true;
            for (Edge e:graph.adjList[u]){
                if (!graph.visited[e.dest] && graph.pathLength[e.dest]>(graph.pathLength[u]+e.weight)){
                    graph.pathLength[e.dest]=graph.pathLength[u]+e.weight;
                    graph.predecessor[e.dest]=u;
                }
            }
        }
    }

    private int findMin(Graph graph) {
        int v=graph.pathLength.length;
        int min=Integer.MAX_VALUE;
        int index=0;
        for (int i=0;i<v;i++){
            if (!graph.visited[i] && min>=graph.pathLength[i]){
                min=graph.pathLength[i];
                index=i;
            }
        }
        return index;
    }

    private boolean allNotVisited(Graph graph) {
        int v=graph.visited.length;
        for (int i=0;i<v;i++){
            if (!graph.visited[i])
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
*/