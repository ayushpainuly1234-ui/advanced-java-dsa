class Solution {
    public class Edge{
       String src;
       String dest;
        Edge(String src,String dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public void dfs( HashMap<String, ArrayList<Edge>> graph,String cur, HashMap<String,Boolean> vmap,List<String> ans){
       vmap.put(cur,true);
        ans.add(cur);
         if (graph.containsKey(cur)) {
        for(int i=0;i<graph.get(cur).size();i++){
            Edge e=graph.get(cur).get(i);
           if (!vmap.containsKey(e.dest)){

                dfs(graph,e.dest,vmap,ans);
            }
        }
        }
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        int n=tickets.size();
        Set<String> nodes=new HashSet<>();

       for(int i=0;i<n;i++){
          nodes.add(tickets.get(i).get(0));
          nodes.add(tickets.get(i).get(1));
       }
       int v=nodes.size();
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
      // Set ko List mein convert karo
List<String> nodeList = new ArrayList<>(nodes);

// Ab simple for loop
for (int i = 0; i < nodeList.size(); i++) {
    graph.put(nodeList.get(i), new ArrayList<>());
}
 for (int i = 0; i < n; i++) {
            String u = tickets.get(i).get(0);
            String k = tickets.get(i).get(1);
            graph.get(u).add(new Edge(u, k));
        }
    //   boolean[] visit=new boolean[v];
    HashMap<String,Boolean> vmap=new HashMap<>();
        List<String> ans=new ArrayList<>();
        if (vmap.isEmpty() && graph.containsKey("JFK")) {
    dfs(graph, "JFK", vmap, ans);
}

       
    //     for(int i=0;i<v;i++){
    //      String cur=nodeList.get(i);
    //         if(!vmap.containsKey(cur)){
    //    dfs(graph,cur,vmap,ans);
    //         }
    //     }
       return ans;
    }
}