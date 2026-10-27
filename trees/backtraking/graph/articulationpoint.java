import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class articulationpoint {

    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static int time=0;

    public static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 3));


    }
  public static void ap(ArrayList<Edge> graph[],int cur,boolean[] visit,
                        int[] low,int[] dt,int perant,boolean[] ap){
       visit[cur]=true;
       dt[cur]=low[cur]=++time;
       int children=0;

           for(int i=0;i<graph[cur].size();i++){
               Edge e=graph[cur].get(i);
               if(e.dest==perant){
                   continue;
               }
               else if(!visit[e.dest]){
                   ap(graph,e.dest,visit,low,dt,cur,ap);
                    low[cur]=Math.min(low[cur],low[e.dest]);
                    if(dt[cur]<=low[e.dest] && perant!=-1){
                       ap[cur]=true;
                    }
                   children++;
               }
               else if(visit[e.dest]){
                   low[cur]=Math.min(low[cur],dt[e.dest]);
               }

           }
      if(perant==-1  &&  children>1 ){
          ap[cur]=true;
      }






  }






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        boolean[] visit = new boolean[v];
        creategraph(graph);
        int[] dt = new int[v];
        int[] low = new int[v];

        int pereant = -1;
       boolean ap[]=new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
               ap(graph, i, visit, low, dt,  pereant,ap);
            }
        }
        for(int i=0;i<ap.length;i++){
            if(ap[i]){
                System.out.println(i);

            }
        }

    }
}




