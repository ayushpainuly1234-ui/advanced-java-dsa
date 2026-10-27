import java.util.Scanner;
import java.util.*;
public class topological{
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
        graph[2].add(new Edge(2,3));
         graph[3].add(new Edge(3,1));
          graph[5].add(new Edge(5,0));
           graph[5].add(new Edge(5,2));
            graph[4].add(new Edge(4,1));
             graph[4].add(new Edge(2,0));
        
        
          
    }
    
    
    public static void topsort( ArrayList<Edge> graph[], boolean[] visit,int cur,Stack<Integer> s){
         visit[cur]=true;
          for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!visit[e.dest]){
                topsort(graph,visit,e.dest,s);
            }
          }
          s.push(cur);
         return;
    }
    public static void helper( ArrayList<Edge> graph[],  boolean[] visit,int v){
         Stack<Integer> s=new Stack<>();
        for(int i=0;i<v;i++){
            if(!visit[i]){
                topsort(graph,visit,i,s);
            }
        }
        while(!s.isEmpty()){
            int x=s.pop();
            System.out.print(x+" ");
        }
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int v=6;
      
        ArrayList<Edge> graph[]=new ArrayList[v];
          creategraph(graph);
         
          boolean[] visit=new boolean[graph.length];
          helper(graph,visit,v);
         
        
         
          
         
         

         
    }
    }




    

