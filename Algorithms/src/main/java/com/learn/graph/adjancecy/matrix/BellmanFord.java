package com.learn.graph.adjancecy.matrix;

import com.learn.util.MyReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord {
    Queue<Integer> queue;
    int[] predecessor;
    int[] pathLength;
    int[][] graph;
    int V, E;
    public static void main(String[] args) {
        new BellmanFord().solve();
    }

    private void solve() {
        MyReader mr=new MyReader();
        V=mr.nextInt();
        E=mr.nextInt();
        predecessor=new int[V];
        pathLength=new int[V];
        graph=new int[V][V];

        Arrays.fill(predecessor, -1);
        Arrays.fill(pathLength, Integer.MAX_VALUE);
        for (int i=0;i<E;i++){
            int u=mr.nextInt();
            int v=mr.nextInt();
            int w=mr.nextInt();
            graph[u][v]=w;
            graph[v][u]=w;
        }

        int src=mr.nextInt();
        int flag = bellmanFord(src);
        if (flag==-1){
            System.out.println("Graph containing negative cycle");
        }
        else{
            for (int i=0;i<V;i++){
                if (pathLength[i]==Integer.MAX_VALUE){
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
        pathLength[src]=0;
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
            for (int v=0;v<V;v++){
                if (graph[u][v]>0 && pathLength[v]>pathLength[u]+graph[u][v]){
                    pathLength[v]=pathLength[u]+graph[u][v];
                    predecessor[v]=u;

                    if (!isPresentInQueue[v]) {
                        queue.offer(v);
                        isPresentInQueue[v]=true;
                    }
                }
            }
        }
        return 1;
    }

    private void findPath(int src, int dest) {
        int[] path=new int[V];
        int i=-1;
        int shortLength=pathLength[dest];
        while (dest!=src){
            path[++i]=dest;
            dest=predecessor[dest];
        }
        System.out.print("Path: " + src);
        for (int j=i;j>=0;j--)
            System.out.print("=>"+path[j]);
        System.out.println("    pathLength: "+shortLength);
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