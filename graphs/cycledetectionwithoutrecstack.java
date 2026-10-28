import java.util.Scanner;
import java.util.*;
public class cycledetectionwithoutrecstack{
    static class Edge{
        int src;
        int dest;
        
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        } 
    }
    public static void creategraph( ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
      graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,0)); 
        
          
    }
    public static boolean cycledetection( ArrayList<Edge> graph[], boolean[] visit,int cur,int perant){
               visit[cur]=true;
               for(int i=0;i<graph[cur].size();i++){
                Edge e=graph[cur].get(i);
                if(visit[e.dest]==true  && perant!=e.dest){
                    return true;
                }
                else if(!visit[e.dest]){
                    if(cycledetection(graph,visit,e.dest,cur)){
                        return true;
                     
                    }
                }
               }
               return false;
    }
    
    
   
   
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int v=6;
      boolean[] visit = new boolean[v];
        ArrayList<Edge> graph[]=new ArrayList[v];

          creategraph(graph);
         boolean cycleFound = false;
       for (int i = 0; i < v; i++) {
        if (!visit[i]) {
        if (cycledetection(graph, visit, i, -1)) {
            cycleFound = true;
            break;
        }
    }
}
           System.out.print(cycleFound);
           sc.close();
         
    }
    }




    

