class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //now we are solve optimal approch
        // topological sorting (kahn algorithm using graph data structure)
        List<String> ans=new ArrayList<>();
        Map<String,List<String>> graph=new HashMap<>();
        Map<String,Integer> indegree=new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            String rec=recipes[i];
            List<String> list=ingredients.get(i);
            for(int j=0;j<list.size();j++){
               String g=list.get(j);
               if(!graph.containsKey(g)){
                graph.put(g,new ArrayList<>());

               } 
               graph.get(g).add(rec);
               indegree.put(rec,indegree.getOrDefault(rec,0)+1);

            }
        }
        Queue<String> q=new LinkedList<>();
        for(int i=0;i<supplies.length;i++){
            q.add(supplies[i]);

        }
        while(!q.isEmpty()){
            String cur=q.poll();
            if(graph.containsKey(cur)){
                List<String> list=graph.get(cur);
                for(int i=0;i<list.size();i++){
                    String dest=list.get(i);
                    indegree.put(dest,indegree.get(dest)-1);
                    if(indegree.get(dest)==0){
                        ans.add(dest);
                        q.add(dest);
                    }
                }

            }
        }
        return ans;

        
    }
}