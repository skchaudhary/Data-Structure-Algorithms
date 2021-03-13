package com.learn.graph.adjancecy.list;

import com.learn.util.MyReader;

import java.util.*;

public class BellmanFordAlgo {
    Queue<Integer> queue;
    Graph graph;
    int V, E;
    public static void main(String[] args) {
        new BellmanFordAlgo().solve();
    }

    private void solve() {
        MyReader mr=new MyReader();
        V=mr.nextInt();
        E=mr.nextInt();
        graph = new Graph(V, E);
        for (int i=0;i<E;i++){
            int u=mr.nextInt();
            int v=mr.nextInt();
            int w=mr.nextInt();
            graph.adjList[u].add(new Edge(u, v, w));
            graph.adjList[v].add(new Edge(v, u, w));
        }

        int src=mr.nextInt();
        int flag = bellmanFord(src);
        if (flag==-1){
            System.out.println("Graph containing negative cycle");
        }
        else{
            for (int i=0;i<V;i++){
                if (graph.pathLength[i]==Integer.MAX_VALUE){
                    System.out.println("There is no path from "+src+" to "+i);
                }else {
                    findPath(src, i);
                }
            }
        }
    }

    private int bellmanFord(int src) {
        queue=new LinkedList<>();
        queue.offer(src);
        graph.pathLength[src]=0;
        boolean[] isPresentInQueue=new boolean[V];
        Arrays.fill(isPresentInQueue, false);
        isPresentInQueue[src]=true;
        int k=0;
        while (!queue.isEmpty()){
            int u=queue.poll();
            isPresentInQueue[u]=false;
            if (src==u)
                k++;
            if (k>V)
                return -1;
            for (Edge e:graph.adjList[u]){
                if (graph.pathLength[e.v]>graph.pathLength[u]+e.weight){
                    graph.pathLength[e.v]=graph.pathLength[u]+e.weight;
                    graph.predecessor[e.v]=u;

                    if (!isPresentInQueue[e.v]) {
                        queue.offer(e.v);
                        isPresentInQueue[e.v]=true;
                    }
                }
            }
        }
        return 1;
    }

    private void findPath(int src, int dest) {
        int[] path=new int[V];
        int i=-1;
        int shortLength=graph.pathLength[dest];
        while (dest!=src){
            path[++i]=dest;
            dest=graph.predecessor[dest];
        }
        System.out.print("Path: " + src);
        for (int j=i;j>=0;j--)
            System.out.print("=>"+path[j]);
        System.out.println("    pathLength: "+shortLength);
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
        int[] predecessor;
        int[] pathLength;
        int V;
        int E;
        List<Edge>[] adjList;
        Graph(int v, int e){
            V=v;
            E=e;
            pathLength=new int[v];
            Arrays.fill(pathLength, Integer.MAX_VALUE);
            predecessor=new int[v];
            Arrays.fill(predecessor, -1);

            adjList=new ArrayList[v];
            for (int i=0;i<v;i++){
                adjList[i]=new ArrayList<>(10);
            }
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

 */