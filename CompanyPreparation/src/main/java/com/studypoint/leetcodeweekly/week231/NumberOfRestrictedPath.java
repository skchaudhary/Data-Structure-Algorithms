package com.studypoint.leetcodeweekly.week231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfRestrictedPath {
    class VW{
        public int v, w;
        public VW(int v, int w){
            this.v=v;
            this.w=w;
        }
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        int[] dist=new int[n+1];
        int[] pred=new int[n+1];
        boolean[] visited=new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(pred, -1);
        dist[n]=0;
        List<VW>[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<VW>();
        }
        for(int[] a:edges){
            adj[a[0]].add(new VW(a[1], a[2]));
            adj[a[1]].add(new VW(a[0], a[2]));
        }

        while(allNotVisited(visited)){
            int u=findMin(visited, dist);
            if(u==-1){
                break;
            }
            visited[u]=true;
            for(VW vw:adj[u]){
                if(dist[vw.v]>dist[u]+vw.w){
                    dist[vw.v]=dist[u]+vw.w;
                    pred[vw.v]=u;
                }
            }
        }

        return dfs(1, n, adj, dist, new Integer[n+1]);
    }

    int dfs(int src, int n, List<VW>[] graph, int[] dist, Integer[] memo) {
        if (memo[src] != null) return memo[src];
        if (src == n) return 1; // Found a path to reach to destination
        int ans = 0;
        for (VW nei : graph[src]) {
            int w = nei.w, v = nei.v;
            if (dist[src] > dist[v])
                ans = (ans + dfs(v, n, graph, dist, memo)) % 1000000007;
        }
        return memo[src] = ans;
    }

    private int findMin(boolean[] visited, int[] dist){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=1;i<visited.length;i++){
            if(!visited[i] && min>dist[i]){
                min=dist[i];
                index=i;
            }
        }
        return index;
    }

    private boolean allNotVisited(boolean[] visited){
        for(int i=1;i<visited.length;i++){
            if(!visited[i]){
                return true;
            }
        }
        return false;
    }
}
