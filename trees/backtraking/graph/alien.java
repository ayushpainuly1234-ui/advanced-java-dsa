 @SuppressWarnings("unchecked")
class Solution {
   
    public class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public void dfs( ArrayList<Edge> graph[],int cur,boolean[] visit,Stack<Integer> st){
        visit[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e= graph[cur].get(i);
            if(!visit[e.dest]){
                dfs(graph,e.dest,visit,st);
            }
        }
        st.push(cur);
    }
    private boolean iscycle( ArrayList<Edge> graph[],int cur,boolean[] visit,boolean[] rec){
        visit[cur]=true;
        rec[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(rec[e.dest]==true){
                return true;
            }
            else if(!visit[e.dest]){
               if(iscycle(graph,e.dest,visit,rec)){
                   return true;
               }

            }
        }
         rec[cur]=false;
        return false;
       
    }
    public String findOrder(String[] words) {
        // code here
        int n=26;
        ArrayList<Edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
            
        }
        
        boolean[] presant=new boolean[n];
        for(int i=0;i<words.length;i++){
         for(int j=0;j<words[i].length();j++){
             char ch=words[i].charAt(j);
             presant[ch-'a']=true;
         }
        }
      
        for(int i=0;i<words.length-1;i++){
            String w1=words[i];
            String w2=words[i+1];
              boolean found=false;
            int length=Math.min(w1.length(),w2.length());
            for(int j=0;j<length;j++){
             int c1=w1.charAt(j)-'a';
             int c2=w2.charAt(j)-'a';
           
                if(c1!=c2){
                    graph[c1].add(new Edge(c1,c2));
                    found=true;
                    break;
                }
              
            }
              if(!found && w1.length()>w2.length()){
                   return "";
                }
            
        }
        boolean[] visit=new boolean[26];
        boolean[] rec=new boolean[26];
        for(int i=0;i<n;i++){
            if(presant[i]  &&  !visit[i]){
               if(iscycle(graph,i,visit,rec)){
                   return "";
               }
            }
        }
      //  topological sorting
      Stack<Integer> st=new Stack<>();
      boolean[] v=new boolean[26];
      for(int i=0;i<n;i++){
            if(presant[i]  &&  !v[i]){
               dfs(graph,i,v,st);
                  
               
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
           int x=st.pop();
            sb.append((char)(x+'a'));
        }
        return sb.toString();
        
        
        
        
    }
}