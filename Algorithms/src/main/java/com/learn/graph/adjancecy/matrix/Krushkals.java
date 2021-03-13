package com.learn.graph.adjancecy.matrix;

import com.learn.util.MyReader;

import java.util.*;

public class Krushkals {
    public static void main(String[] args) {
        new Krushkals().solve();
    }
    int V;
    int E;
    List<Edge> list=new ArrayList<>();
    int[] predecessor;
    private void solve() {
        MyReader mr=new MyReader();
        V=mr.nextInt();
        E=mr.nextInt();
        for (int i=0;i<E;i++){
            int u=mr.nextInt();
            int v=mr.nextInt();
            int w=mr.nextInt();
            list.add(new Edge(u,v,w));
            list.add(new Edge(v,u,w));
        }
        Collections.sort(list, new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.weight>o2.weight) return 1;
                else if (o1.weight<o2.weight) return -1;
                else return 0;
            }
        });
        predecessor=new int[V];
        Arrays.fill(predecessor, -1);
        Edge edge=null;
        Edge tmp=null;
        for (Edge e:list){
            if (isNotFormingCycle(e)){
                Edge edge1=new Edge();
                edge1.src=e.src;
                edge1.v=e.v;
                edge1.weight=e.weight;
                edge1.next=null;
                if (edge!=null){
                    tmp.next=edge1;
                    tmp=tmp.next;
                }else {
                    edge=tmp=edge1;
                }
            }
        }

        while (edge!=null){
            System.out.println(edge.src+" "+edge.v+"  "+edge.weight);
            edge=edge.next;
        }
    }

    private boolean isNotFormingCycle(Edge e) {
        int x = find(e.src);
        int y = find(e.v);

        if (x == y)
            return false;
        Union(x, y);
        return true;
    }

    private void Union(int x, int y) {
            int xset=find(x);
            int yset=find(y);
            predecessor[yset]=xset;
    }

    private int find(int src) {
        if (predecessor[src]==-1)
            return src;
        return find(predecessor[src]);
    }

    class Edge {
        public int src;
        public int v;
        public int weight;
        Edge next;
        Edge(){}
        Edge(int s, int d, int w){
            src=s;
            v=d;
            weight=w;
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