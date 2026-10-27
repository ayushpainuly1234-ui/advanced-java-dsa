import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class kosarajualgorithm {
      public  static class Edge{
            int src;
            int dest;

            public Edge(int src,int dest){
                this.src=src;
                this.dest=dest;
            }
        }
        public static void creategraph( ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            graph[0].add(new Edge(0, 2));
            graph[1].add(new Edge(1, 0));
            graph[2].add(new Edge(2, 1));
            graph[0].add(new Edge(0, 3));
            graph[3].add(new Edge(3, 4));


        }
        public static void createtranspose( ArrayList<Edge> transpose[], ArrayList<Edge> graph[],int v,boolean visit[]){
           for(int i=0;i<v;i++){
              visit[i]=false;   //  false all the index;
              transpose[i]=new ArrayList<>();
           }
         for(int k=0;k<v;k++){
             for(int j=0;j<graph[k].size();j++){
                 Edge e=graph[k].get(j);
                 transpose[e.dest].add(new Edge(e.dest,e.src));

             }
         }
        }


        public static void topological(ArrayList<Edge> graph[],int source, Stack<Integer> st,boolean[] visit){
           visit[source]=true;
          for (int i = 0; i < graph[source].size(); i++) {
           Edge e=graph[source].get(i);
              if(!visit[e.dest]){
                  topological(graph,e.dest,st,visit);
                }
          }
        st.push(source);
        }
    public static void dfs2(ArrayList<Edge> graph[],  boolean[] visit,int start){
        visit[start]=true;
        System.out.print(start+" ");
        for(int i=0;i<graph[start].size();i++){
            Edge e=graph[start].get(i);
            if(!visit[e.dest]){
                dfs2(graph,visit,e.dest);

            }

        }
        return;

    }


public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int v = 5;
    ArrayList<Edge> graph[]=new ArrayList[v];
    creategraph(graph);
    boolean[] visit=new boolean[v];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < v; i++) {
        if (!visit[i]){
            topological(graph, i, st, visit);
        }
    }
    ArrayList<Edge> transpose[] = new ArrayList[v];
    createtranspose(transpose,graph,v,visit);
    
  while(!st.isEmpty()){
      int cur=st.pop();

      if(!visit[cur]){

          dfs2(transpose,visit,cur);
      }
      System.out.println();
  }

}
}





