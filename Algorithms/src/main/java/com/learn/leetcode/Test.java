package com.learn.leetcode;

import javafx.util.Pair;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    static int V,E;
    static class Edge implements Comparable<Edge>{
        int u,v,wt;
        Edge(int u, int v, int wt){
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Edge e){
            return -(this.wt-e.wt);
        }
    }
    static int[][] dp;
    static int M,N;
    public static void main (String[] args) throws IOException{
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
	    /*
	    M=in.nextInt();
	    N=in.nextInt();
	    int[][] arr=new int[M][N];
	    for(int i=0;i<M;i++){
	        for(int j=0;j<N;j++){
	            arr[i][j]=in.nexxtInt();
	        }
	    }*/
            N=in.nextInt();
            V=26;
            String[] s=new String[N];
            for(int i=0;i<N;i++){
                s[i]=in.next();
            }
            int ans = solve(s);
            System.out.println(ans);
        }
    }
    static class Visit{
        int pre, next;
    }
    private static int solve(String[] S){
        ArrayList<Integer>[] adj = new ArrayList[V];
        int[] in = new int[V];
        for (int i = 0; i < V; i++) {
            adj[i]=new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++)
        {
            String s = S[i];
            adj[s.charAt(0)-'a'].add(s.charAt(s.length()-1)-'a');
            in[s.charAt(s.length()-1)-'a']++;
        }

        if (!isSC(adj, in))
            return 0;

        for (int i = 0; i < V; i++)
            if (adj[i].size() != in[i])
                return 0;

        return 1;
    }

    private static boolean isSC(List<Integer>[] adj, int[] in){
        // Mark all the vertices as not visited (For first DFS)
        boolean[] visited= new boolean[V];
        int n;
        for (n = 0; n < V; n++)
            if (adj[n].size() > 0)
                break;
        // Do DFS traversal starting from first non zero degree vertex.
        DFSUtil(n, visited, adj);

        // If DFS traversal doesn’t visit all vertices, then return false.
        for (int i = 0; i < V; i++)
            if (adj[i].size() > 0 && !visited[i])
                return false;

        //transpose
        ArrayList<Integer>[] adj1 = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj1[v]=new ArrayList<>(adj[v]);
        }
        for (int v = 0; v < V; v++) {
            for(int i:adj1[v]) {
                adj[i].add(v);
                in[v]++;
            }
        }

        Arrays.fill(visited, false);
        DFSUtil(n, visited, adj);
        for (int i = 0; i < V; i++)
            if (adj[i].size() > 0 && !visited[i])
                return false;
        return true;
    }

    private static void DFSUtil(int n, boolean[] visited,
                                List<Integer>[] adj){
        visited[n]=true;
        for(int v:adj[n]){
            if(!visited[v]){
                DFSUtil(v, visited, adj);
            }
        }
    }

    private static boolean isNotVisited(int v, List<Integer> path){
        for(int u:path){
            if(v==u){
                return false;
            }
        }
        return true;
    }


    private static int max(int a, int b){
        return a>b?a:b;
    }
    private static long max(long a, long b){
        return a>b?a:b;
    }
    private static int min(int a, int b){
        return a>b?b:a;
    }
}
class Parser{
    public boolean isBalanced(String s){
        if(s==null || s.equals("")){
            return true;
        }
        Stack<Character> st=new Stack<>();
        char[] ch=s.toCharArray();
        System.out.println(s);
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='{' || ch[i]=='('){
                st.push(ch[i]);
            }else if(st.size()>0 && (char)st.peek() == ch[i]){
                st.pop();
            }else{
                st.push(ch[i]);
            }
        }
        return st.size()==0;
    }
}
