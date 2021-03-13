package com.learn.graph.adjancecy.list;

import com.learn.util.MyReader;

import java.util.*;

public class KrushkalAlgo {
    public static void main(String[] args) {
        new KrushkalAlgo().solve();
    }
    int V, E;
    int[] predecessor;
    List<Edge> adjList;
    private void solve() {
        MyReader mr=new MyReader();
        V=mr.nextInt();
        E=mr.nextInt();
        adjList=new ArrayList<>();
        predecessor=new int[V];
        Arrays.fill(predecessor, -1);
        for (int i=0;i<E;i++){
            adjList.add(new Edge(mr.nextInt(), mr.nextInt(), mr.nextInt()));
        }
        krushkals();
    }

    Edge tree=null;
    Edge edge=null;
    private void krushkals() {
        Collections.sort(adjList, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.weight>o2.weight) return 1;
                else if (o1.weight<o2.weight) return -1;
                else return 0;
            }
        });

        for (Edge e:adjList){
            if (edgeNotFormingCycle(e)){
                Edge tmp=new Edge(e.src, e.dest, e.weight);
                if (tree!=null){
                    edge.next=tmp;
                    edge=edge.next;
                } else {
                    edge=tree=tmp;
                }
            }
        }

        for (Edge e:adjList){
            System.out.println(e.src+" "+e.dest+"  "+e.weight);
        }
        System.out.println("Minimum spanning tree: ");
        while (tree!=null){
            System.out.println(tree.src+" "+tree.dest+"  "+tree.weight);
            tree=tree.next;
        }
    }

    private boolean edgeNotFormingCycle(Edge e) {
        int x=find(e.src);
        int y=find(e.dest);
        if (x==y)
            return false;
        union(x, y);
        return true;
    }

    private void union(int x, int y) {
//        int xset=find(x);
//        int yset=find(y);
        predecessor[y]=x;
    }

    private int find(int src) {
        if (predecessor[src]==-1)
            return src;
        return find(predecessor[src]);
    }


    class Edge{
        int src, dest, weight;
        Edge next;
        Edge(int s, int d, int w){
            src=s;
            dest=d;
            weight=w;
            next=null;
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
0
Spanning tree
0 1  6
0 2  2
0 3  3
5 4  4
3 5  5

 */