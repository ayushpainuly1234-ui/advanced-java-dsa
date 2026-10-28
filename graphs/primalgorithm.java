import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.*;

public class primalgorithm {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void creategraph(ArrayList<Edge> graph[], int v) {

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 50));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    public static class pair implements Comparable<pair>{
        int node;
        int dis;
        public pair  (int node,int dis){
            this.node=node;
            this.dis=dis;
        }
        @Override

        public int compareTo(pair p2){
            return this.dis-p2.dis;
        }

    }
    public static void prim(ArrayList<Edge> graph[],boolean[] visit,int source){
        PriorityQueue<pair> pq=new PriorityQueue<>();
        int v= graph.length;
        int mstcost=0;
        pq.add(new pair(source,0));
        while(!pq.isEmpty()){
            pair cur=pq.remove();
            if(!visit[cur.node]) {
                mstcost += cur.dis;
                visit[cur.node]=true;
                for (int i = 0; i < graph[cur.node].size(); i++) {
                    Edge e = graph[cur.node].get(i);
                   if (!visit[e.dest]) {
                        pq.add(new pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println( "the minimum cost is a ->"+mstcost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = 4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creategraph(graph, v);
        boolean[] visit=new boolean[v];
        int source=0;
        prim(graph,visit,source);
    }
}
