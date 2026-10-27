class Solution {
    public void dfs(HashMap<String,PriorityQueue<String>> graph,String cur,Stack<String> st){
        // use the algorithm -> HIERHOLZER ALGORITHM;
        //GRAPH + EULERPATH->HIERHOLZER ALGORITHM OKAY ;
        PriorityQueue<String> pq=graph.get(cur); // priority queue sort the alphabetically okay;
        while(pq!=null &&  !pq.isEmpty()){
            String next=pq.poll();
            dfs(graph,next,st);
        }
        st.push(cur); // backtraking(very very important according to the algorithm okay);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        int n=tickets.size();
        //create a graph 
        HashMap<String,PriorityQueue<String>> graph=new HashMap<>();
        for(int i=0;i<n;i++){
            String u=tickets.get(i).get(0);
            String v=tickets.get(i).get(1);
            if(!graph.containsKey(u)){
                graph.put(u, new PriorityQueue<String>());
            }
            graph.get(u).add(v);  
        }
        Stack<String> st=new Stack<>();
         List<String> ans=new ArrayList<>();
         dfs(graph,"JFK",st);
         while(!st.isEmpty()){
            String cur=st.pop();
            ans.add(cur);
         }
         return ans;


    }
}