package com.learn.graph;

import java.util.*;

public class NumberOfShortestPaths
{
    static class Graph{
        int v;
        List<Integer>[] adjList;
        Graph(int v){
            this.v=v;

            adjList=new ArrayList[v];
            for (int i=0;i<v;i++)
                adjList[i]=new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Graph graph=new Graph(7);
        graph.adjList[0].add(1);
        graph.adjList[0].add(2);
        graph.adjList[1].add(2);
        graph.adjList[1].add(3);
        graph.adjList[2].add(3);
        graph.adjList[3].add(4);
        graph.adjList[3].add(5);
        graph.adjList[4].add(6);
        graph.adjList[5].add(6);
        findShortestPaths(graph, 0, 7);
    }

    private static void findShortestPaths(Graph graph, int src, int n) {
        int[] dist=new int[n];
        int[] paths=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(paths, 0);
        bfs(graph, src, dist, paths, n);
        for (int a:paths)
            System.out.println(a);
    }

    private static void bfs(Graph graph, int src, int[] dist, int[] paths, int n) {
        boolean[] visited=new boolean[n];
        Arrays.fill(visited, false);

        Queue<Integer> deque = new LinkedList<>();
        deque.offer(src);
        dist[src]=0;
        paths[src]=1;
        visited[src]=true;
        while (!deque.isEmpty()){
            int u=deque.poll();
            for (int v:graph.adjList[u]){
                if (!visited[v]){
                    deque.offer(v);
                    visited[v]=true;
                }
                if (dist[v]>dist[u]){
                    if (dist[v]==dist[u]+1){
                        paths[v]+=paths[u];
                    }
                    else {
                        dist[v]=dist[u]+1;
                        paths[v]=paths[u];
                    }
                }
            }
        }
    }
}
