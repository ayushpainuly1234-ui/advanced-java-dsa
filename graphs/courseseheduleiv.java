class Solution {
    public class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;

        }
    }
    void topo( ArrayList<Edge> graph[],int cur,boolean[] visit,  Stack<Integer> st){
        visit[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!visit[e.dest]){
                topo(graph,e.dest,visit,st);
            }
        }
        st.push(cur);// backtraking very imp okay;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // create a graph using edge list
        int n=numCourses;
        ArrayList<Edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        Stack<Integer> st=new Stack<>();
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                topo(graph,i,visit,st);
            }
        }
        // using dp with dag (directed graph);
        int[][] dp=new int[n][n];
        while(!st.isEmpty()){
            int cur=st.pop();
            for(int i=0;i<graph[cur].size();i++){
                Edge e=graph.get(i);
                int u=e.src;
                int v=e.dest;
                dp[u][v]=true;
                for(int j=0;j<n;j++){
                    if(dp[j][u]==true){
                        dp[j][v]==true;  // dry run 0->1   1->2 so the parent of 2 in 1 very imp please dry run
                    }
                }
            }
        }
         List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int src=queries[i][0];
            int dest=queries[i][1];
            
            ans.add(dp[src][dest]);
        }
        return ans;
        

    }
}