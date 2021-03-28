package com.learn.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Util
{


    static int MAXN=5*1000001; static int arr[]=new int[MAXN];
    static int spf[] = new int[MAXN];

    static long power(long x, long y)
    {

        long res = 1;
        x=x%1000000007L;
        while (y > 0)
        {

            if ((y & 1) == 1)
                res = ((res) * (x))%1000000007L;


            y = y >> 1;
            x = ((x)) *((x))%1000000007L;
        }
        return res%1000000007L;
    }


    static void constructPrime(boolean prime[],int n)
    {
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {

            if(prime[p] == true)
            {

                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }


    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }


    private static void union(int[] parent,int src,int dest)
    {
        int a = find(parent,src);
        int b = find(parent,dest);
        if(a!=b)
            parent[a]=b;
        return;
    }
    private static int find(int[] parent, int source)
    {
        if(parent[source]==-1)
            return source;
        return find(parent,parent[source]);
    }

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public static void sieves()
    {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)
            spf[i] = i;
        for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;
        for (long i=3; i*i<MAXN; i++)
        {
            if (spf[(int)i] == i)
            {
                for (long j=i*i; j<MAXN; j+=i)
                    if (spf[(int)j]==j)
                        spf[(int)j] = (int)i;
            }
        }
    }
    static void getFactorizations(int x)
    {
        int num=x;
        while (x != 1)
        {
            arr[num]++;
            x = x / spf[x];
        }
    }

    public static void main(String ag[])
    {
        FastReader sc=new FastReader();
        /*ArrayList<Integer> al=new ArrayList<Integer>();*/
        /*String s=sc.nextLine();*/
        //hm.containsKey(); hm.get(k); hm.put(k,v); HashMap<Integer,Integer> hm=new HashMap<>();
        /*String[] arrOfStr = s.split(" "); */
        /*boolean visited[]=new boolean[arrOfStr.length];*/

        int i,j;
        int M=sc.nextInt();
        int N=sc.nextInt();
        int arr[]=new int[M];
        int mod=1000000000+7;
        for(i=0;i<M;i++)
        {
            arr[i]=sc.nextInt();
        }
        int dp[]=new int[N+1];
        dp[0]=1;
        for(i=0;i<M;i++)
        {
            for(j=0;j<=N;j++)
            {
                if(arr[i]<=j)
                    dp[j]=(dp[j]+dp[j-arr[i]])%mod;
            }
        }
        System.out.println(dp[N]);
    }

}

class Edge
{
    int v,w;
    Edge(int v,int w)
    {
        this.v=v;
        this.w=w;
    }
}

class Graph
{
    int V;
    int E;
    boolean visited[];
    ArrayList<Edge> adjLists[];

    Graph(int V,int E)
    {
        this.V=V;
        this.E=E;
        visited=new boolean[V+1];
        adjLists=new ArrayList[V+1];

        for (int i = 0; i <=V; i++)
        {
            adjLists[i]=new ArrayList<Edge>();
        }

    }


    public void addEdge(int s,int d)
    {

        Edge e=new Edge(d,0);
        adjLists[s].add(e);
        Edge e1=new Edge(s,0);
        adjLists[d].add(e1);

    }


    public int DFS(int v)
    {
        visited[v]=true;
        int y=0;
        Iterator<Edge> i = adjLists[v].listIterator();
        if(!i.hasNext())
            return 0;
        while (i.hasNext())
        {
            Edge e=i.next();
            int n = e.v;

            if(!visited[n])
            {
                y= Math.max(1+DFS(n),y);
            }
        }
        return y;
    }

    public boolean isEulerCircuit()
    {
        for(int i=1;i<=V;i++)
        {
            if(adjLists[i].size()%2!=0)
                return false;
        }
        return true;
    }
    public void BFS()
    {
        Queue<Edge> q=new LinkedList<>();
        int price[]=new int[V+1];
        Arrays.fill(price,Integer.MAX_VALUE);
        q.add(new Edge(1,0));
        price[1]=0;
        while(!q.isEmpty())
        {
            Edge e=q.poll();
            int cost=e.w;
            if(e.v!=V)
            {
                for(Edge s:adjLists[e.v])
                {
                    if(cost+s.w<price[s.v])
                    {
                        price[s.v]=cost+s.w;
                        q.add(new Edge(s.v,cost+s.w));
                    }
                }
            }
        }
        if(price[V]==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(price[V]);
    }

}


class Tcomp implements Comparator<Node>
{
    @Override
    public int compare(Node e1, Node e2) {
        if(e1.e<e2.e)
        {
            return 1;
        }
        else if(e1.e>e2.e)
        {
            return -1;
        }
        if(e1.d<e2.d)
        {
            return 1;
        }
        else if(e1.d>e2.d)
        {
            return -1;
        }

        if(e1.b<e2.b)
        {
            return 1;
        }
        else if(e1.b>e2.b)
        {
            return -1;
        }

        if(e1.a<e2.a)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

}


class Node
{
    int a;
    int b;
    int c;
    int d;
    int e;
    Node(int a,int b,int c,int d,int e)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;


    }
}


class FastReader {

    BufferedReader bf;
    StringTokenizer st;

    public FastReader() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(bf.readLine());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = bf.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        return str;
    }
}