package com.learn.graph;

import java.util.*;

public class BFS
{
    static class Graph{
        private int v;
        List<Integer>[] adjList;
        Graph(int v){
            this.v=v;
            adjList=new ArrayList[v];
            for(int i=0;i<v;i++)
                adjList[i]=new ArrayList<>();
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int vertex=scanner.nextInt();
        Graph graph=new Graph(vertex);
        int edge= scanner.nextInt();
        int u,v;
        for(int i=0;i<edge;i++){
            u=scanner.nextInt();
            v=scanner.nextInt();
            graph.adjList[u].add(v);
            //for undirected graph, if graph is directed
            // then will not add next line od code
            graph.adjList[v].add(u);
        }
        bfs(graph);
    }

    private static void bfs(Graph graph) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[graph.adjList.length];
        int[] dist=new int[graph.adjList.length];
        Arrays.fill(visited, false);
        queue.offer(0);
        visited[0]=true;
        int u;
        while (!queue.isEmpty()){
            u=queue.poll();
            System.out.print(u+"-->");
            for(Integer v:graph.adjList[u]){
                if (!visited[v]){
                    visited[v]=true;
                    queue.offer(v);
                    dist[v]=dist[u]+1;
                }
            }
        }
        System.out.println("\ndistance of each node from 0");
        for (int i=0;i<graph.adjList.length;i++){
            System.out.println(i+" ==> "+dist[i]);
        }
    }
}
/*
10
15
0 1
0 6
0 8
1 4
1 6
1 9
2 4
2 6
3 4
3 5
3 8
4 5
4 9
7 8
7 9
 */

/*
result:
0-->1-->6-->8-->4-->9-->2-->3-->7-->5-->
distance of each node from 0
0 ==> 0
1 ==> 1
2 ==> 2
3 ==> 2
4 ==> 2
5 ==> 3
6 ==> 1
7 ==> 2
8 ==> 1
9 ==> 2

 */