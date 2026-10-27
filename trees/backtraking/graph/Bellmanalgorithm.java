import java.util.ArrayList;
import  java.util.Scanner;
public class Bellmanalgorithm {
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
    public static void creategraph(ArrayList<Edge> graph[], int v){

        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[3].add(new Edge(3,4,4));

        graph[2].add(new Edge(2,3,2));

        graph[4].add(new Edge(4,1,-10));



    }
    public static void Bellman( ArrayList<Edge> graph[],int source){

        int[] dest=new int[graph.length];
        dest[source]=0;
        for(int i=0;i< graph.length;i++){
            if(i!=source){
                dest[i]=Integer.MAX_VALUE;
            }
        }
        for(int k=0;k< graph.length;k++){
            for(int i=0;i< graph.length;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e=graph[i].get(j);
                    int u=e.src;
                    int v=e.dest;
                    if(dest[u]!=Integer.MAX_VALUE  &&  dest[u]+e.wt<dest[v]){
                        dest[v]=dest[u]+e.wt;
                    }
                }
            }
        }
          for(int i=0;i< graph.length;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e=graph[i].get(j);
                    int u=e.src;
                    int v=e.dest;
                    if(dest[u]!=Integer.MAX_VALUE  &&  dest[u]+e.wt<dest[v]){
                        System.out.println("negative wt cycle ");
                     
                    }
                }
            }
        for(int i=0;i< graph.length;i++){
            System.out.print(dest[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creategraph(graph,v);



        Bellman(graph,0);

    }
}
