import java.util.*;
class Solution {
    public class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    int dfs(ArrayList<Edge> graph[],int cur,int[] dp,int[] quiet){
        // use dfs
        // use dynamic prograaming its mean memoization for efficient code okay
        if(dp[cur]!=-1){
            return dp[cur];
        }
        int best=cur;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
          int next=  dfs(graph,e.dest,dp,quiet);
          if(quiet[next]<quiet[best]){ //please dry run
            best=next;
          }
        }
       dp[cur]=best;
        return best;
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // create a graph using edge list
        int n=quiet.length;
        ArrayList<Edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<richer.length;i++){
            int u=richer[i][1];// u is rich //[1,0],   1 is rich as compare to 0 okay
            int v=richer[i][0];// because second is not rich 
            graph[u].add(new Edge(u,v));//because this graph is dag directed graph

        }
        // create a dp array its mean ans store the ans dp array;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            dfs(graph,i,dp,quiet);
        }
    return dp;
        
    }
}