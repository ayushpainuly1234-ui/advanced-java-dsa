import java.util.Scanner;
import java.util.*;
public class graph{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
            
            
        } 

    }
    public static void creategraph( ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();

        }
        // create a graph data structure.
        graph[0].add(new Edge(0,2,6));
        graph[1].add(new Edge(1,2,-8));
        graph[1].add(new Edge(1,3,7));
        graph[2].add(new Edge(2,3,7));
        graph[2].add(new Edge(2,1,8));
        graph[3].add(new Edge(3,2,6));
        graph[3].add(new Edge(3,1,2));
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int v=4;
      
        ArrayList<Edge> graph[]=new ArrayList[v];
          creategraph(graph);
          // print 
          for(int i=0;i<graph[1].size();i++){
            Edge e=graph[1].get(i);
            System.out.println(e.src+","+e.dest+" ,"+e.wt);
          }
        
    }
}
