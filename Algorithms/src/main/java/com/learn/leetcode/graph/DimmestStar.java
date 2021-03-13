package com.learn.leetcode.graph;

import java.util.*;

public class DimmestStar {
    static class Graph{
        int v;
        List<Integer>[] adjList;
        Graph(int n){
            v=n;
            adjList=new ArrayList[v+1];
            for(int i=1;i<=v;i++){
                adjList[i]=new ArrayList<Integer>();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            Solution.Graph g=new Solution.Graph(n);
            for (int i=1;i<n;i++) {
                g.adjList[sc.nextInt()].add(sc.nextInt());
            }
            int s=sc.nextInt();
            bfs(s, g, n);
        }
    }

    private static void bfs(int s, Solution.Graph g, int n) {
        int[] dist=new int[n+1];
        dist[s]=0;
        boolean[] visited=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()){
            int u=q.poll();
            visited[u]=true;
            for(Integer v:g.adjList[u]){
                if (!visited[v]){
                    q.offer(v);
                    dist[v]=dist[u]+1;
                }
            }
        }
        int max=0, index=0;
        for (int i=1;i<=n;i++){
            if (max<dist[i]){
                max=dist[i];
                index=i;
            }
        }
        System.out.println(index);
    }
}
