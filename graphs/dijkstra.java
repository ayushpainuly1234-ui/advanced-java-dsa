import java.util.Scanner;
import java.util.*;
public class dijkstra{
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    // time compexity  o(E+Elogn);
    public static void creategraph(ArrayList<Edge> graph[],int v){
       
        for(int i=0;i<v;i++){
             graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
         graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,3,7));
         graph[1].add(new Edge(1,2,1));
           graph[2].add(new Edge(2,4,3));
            graph[4].add(new Edge(4,3,2)); 
           graph[4].add(new Edge(4,5,5));   
            graph[3].add(new Edge(3,5,1)); 
          


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
    public static void dijkstra( ArrayList<Edge> graph[],boolean[] visit,int source){
     PriorityQueue<pair> pq=new PriorityQueue<>();
     int[] dist=new int[visit.length];
     for(int i=0;i<dist.length;i++){
        if(i!=source){
            dist[i]=Integer.MAX_VALUE;

        }
     }
     pq.add(new pair(0,0));
    while(!pq.isEmpty()){
        pair cur=pq.remove();
        if(!visit[cur.node]){
          visit[cur.node]=true;

        for(int i=0;i<graph[cur.node].size();i++){
            Edge e=graph[cur.node].get(i);
            int u=e.src;
            int v=e.dest;
            if(dist[u]+e.wt<dist[v]){
                dist[v]=dist[u]+e.wt;
                pq.add(new pair(v,dist[v]));

            }
             


        }
        }

    }
    for(int i=0;i<dist.length;i++){
        System.out.print(dist[i]+" ");
    }
    
    }
    public static void main(String[] args){

        int v=6;
    ArrayList<Edge> graph[]=new ArrayList[v];
    creategraph(graph,v);
    boolean[] visit=new boolean[v];
  
   
    dijkstra(graph,visit,0);
    }

}


