package com.learn.graph;

import java.util.*;

public class DFS
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
        dfs(graph);
    }

    private static void dfs(Graph graph) {
        boolean[] visited=new boolean[graph.adjList.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int u;
        Arrays.fill(visited, false);
        visited[0]=true;

        //can define parameter to measure minimum distance from 0 to other vertex
        int[] dist=new int[graph.adjList.length];
        dist[0]=0;
        while (!stack.empty()){
            u=stack.pop();
            System.out.print(u+"-->");
            for(Integer v:graph.adjList[u]){
                if(!visited[v]){
                    stack.push(v);
                    visited[v]=true;
                    dist[v]=dist[u]+1;
                }
            }
        }
        System.out.println("\nDistance from 0 vertex to other vertex");
        for (int i=0;i<graph.adjList.length;i++) {
            System.out.println(i+ "  ==>  "+dist[i]);
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
0-->8-->7-->9-->4-->5-->2-->3-->6-->1-->
Distance from 0 vertex to other vertex
0  ==>  0
1  ==>  1
2  ==>  5
3  ==>  2
4  ==>  4
5  ==>  5
6  ==>  1
7  ==>  2
8  ==>  1
9  ==>  3
 */