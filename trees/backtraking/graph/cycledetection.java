import java.util.Scanner;
import java.util.*;
public class cycledetection{
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
        // create a graph data structure. 
graph[0].add(new Edge(0,1));
graph[0].add(new Edge(0,2));
graph[1].add(new Edge(1,3));
graph[2].add(new Edge(2,4));
graph[3].add(new Edge(3,5));
graph[4].add(new Edge(4,6));



       
    }
   public static boolean cycledetection(ArrayList<Edge> graph[], boolean[] visit,int cur, boolean[] recstack){
               recstack[cur]=true;
               visit[cur]=true;
               for(int i=0;i<graph[cur].size();i++){
                Edge e=graph[cur].get(i);
                if(recstack[e.dest]==true){
                    return true;
                }
                else if(!visit[e.dest]){
                 if (cycledetection(graph,visit,e.dest,recstack)==true){
                      return true;
                 }
                }
                
               }
             recstack[cur]=false;
               return false;
   }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int v=7;
      
        ArrayList<Edge> graph[]=new ArrayList[v];
          creategraph(graph);
          boolean[] visit=new boolean[graph.length];
           boolean[] recstack=new boolean[graph.length];
          boolean cycleFound = false;
       for (int i = 0; i < v; i++) {
        if (!visit[i]) {
        if (cycledetection(graph, visit, i, recstack)) {
            cycleFound = true;
            break;
        }
        }
    
}
System.out.print(cycleFound);
            

         
         
         
         
        
    }
}
