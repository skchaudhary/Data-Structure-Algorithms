package com.learn.graph;

import java.util.*;

public class DimmestStar {
    static class Graph{
        private int v;
        List<Integer>[] adjList;
        Graph(int v){
            this.v=v+1;
            adjList=new ArrayList[this.v];
            for(int i=0;i<this.v;i++)
                adjList[i]=new ArrayList<>();
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            int edge=scanner.nextInt();
            Graph graph=new Graph(edge);
            int u,v;
            for(int i=1;i<edge;i++){
                u=scanner.nextInt();
                v=scanner.nextInt();
                graph.adjList[u].add(v);
            }
            int start=scanner.nextInt();
            bfs(graph, start);
        }
    }

    private static void bfs(Graph graph, int start) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[graph.adjList.length];
        int[] dist=new int[graph.adjList.length];
        Arrays.fill(visited, false);
        queue.offer(start);
        visited[start]=true;
        int u;
        while (!queue.isEmpty()){
            int size=queue.size();
            int index=Integer.MAX_VALUE;
            for(int k=0;k<size;k++){
                u=queue.poll();
                for(Integer v:graph.adjList[u]){
                    if (!visited[v]){
                        visited[v]=true;
                        queue.offer(v);
                        dist[v]=dist[u]+1;
                    }
                }
                if (u<index){
                    index=u;
                }
            }
            if (queue.isEmpty()){
                System.out.println(index);
            }
        }
    }
}
