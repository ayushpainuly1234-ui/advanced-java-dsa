import java.util.Scanner;
import java.util.*;
public class sourcetotarget{
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
            graph[1].add(new Edge(1,0));
             graph[2].add(new Edge(2,0));
             graph[2].add(new Edge(2,4));
             graph[3].add(new Edge(3,1));
             graph[3].add(new Edge(3,5));
             graph[3].add(new Edge(3,4));
             graph[4].add(new Edge(4,2));
             graph[4].add(new Edge(4,5));
             graph[4].add(new Edge(4,3));
             graph[5].add(new Edge(5,3));
             graph[5].add(new Edge(5,4));
             graph[5].add(new Edge(5,6));
             graph[6].add(new Edge(6,5));



       
    }
    public static void allpath( ArrayList<Edge> graph[], boolean[] visit,int start,String str,int target){
        //basecase
         visit[start]=true;
        if(start==target){
            System.out.println(str);
              visit[start]=false;
            return;
        }

         for(int i=0;i<graph[start].size();i++){
            Edge e=graph[start].get(i);
           
            if(!visit[e.dest]){
                
                allpath(graph,visit,e.dest,str+"->"+e.dest,target);
                
            }
          
         }
          visit[start]=false; //backtraking
          
        
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int v=7;
      
        ArrayList<Edge> graph[]=new ArrayList[v];
          creategraph(graph);
          boolean[] visit=new boolean[graph.length];
          int src=0;
           int target=5;
           allpath(graph,visit,0,src+"",target);
          
         
         
         
        
    }
}
