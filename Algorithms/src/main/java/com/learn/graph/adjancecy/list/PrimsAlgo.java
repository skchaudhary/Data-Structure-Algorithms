package com.learn.graph.adjancecy.list;

import com.learn.util.MyReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimsAlgo {
    int V, E;
    public static void main(String[] args) {
        new PrimsAlgo().solve();
    }

    private void solve() {
        MyReader mr = new MyReader();
        V = mr.nextInt();
        E = mr.nextInt();
        Graph graph = new Graph(V, E);
        for (int i = 0; i < E; i++) {
            int u = mr.nextInt();
            int v = mr.nextInt();
            int w = mr.nextInt();
            graph.adjList[u].add(new Edge(u, v, w));
            graph.adjList[v].add(new Edge(v, u, w));
        }
        int src = mr.nextInt();
        prims(graph, src);
    }

    private void prims(Graph graph, int src) {
        boolean[] visited=new boolean[V];
        int[] pathLength=new int[V];
        int[] predecessor=new int[V];
        Arrays.fill(visited, false);
        Arrays.fill(pathLength, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);

        pathLength[src]=0;
        Edge edge=null;
        Edge tmp=null;
        while (notVisitedAllVertex(visited)){
            int u=fidMin(visited, pathLength);
            visited[u]=true;
            for (Edge e:graph.adjList[u]){
                if (!visited[e.dest] && pathLength[e.dest]>e.wt){
                    pathLength[e.dest]=e.wt;
                    predecessor[e.dest]=u;
                }
            }
        }
        for (int i=1;i<V;i++){
            Edge edge1=new Edge(predecessor[i], i, pathLength[i]);
            if (edge!=null){
                tmp.next=edge1;
                tmp=tmp.next;
            }else {
                edge=tmp=edge1;
            }
        }
        System.out.println("Spanning tree");
        while (edge!=null){
            System.out.println(edge.src+" "+edge.dest+"  "+edge.wt);
            edge=edge.next;
        }
    }

    private int fidMin(boolean[] visited, int[] pathLength) {
        int min=Integer.MAX_VALUE;
        int index=-1;
        for (int i=0;i<V;i++){
            if (!visited[i] && min>pathLength[i]){
                min=pathLength[i];
                index=i;
            }
        }
        return index;
    }

    private boolean notVisitedAllVertex(boolean[] visited) {
        for (int i=0;i<V;i++){
            if (!visited[i])
                return true;
        }
        return false;
    }


    class Edge{
        int src, dest, wt;
        Edge next;
        Edge(int s, int d, int w){
            src=s;
            dest=d;
            wt=w;
            next=null;
        }
    }
    class Graph{
        int v,e;
        List<Edge>[] adjList;
        Graph(int v, int e){
            this.v=v;
            this.e=e;
            adjList=new ArrayList[v];
            for (int i=0;i<v;i++)
                adjList[i]=new ArrayList<>();
        }
    }
}

/**

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

 */