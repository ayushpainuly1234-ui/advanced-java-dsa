class Solution {
    public class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // create the iteam graph
        ArrayList<Edge> iteam[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            iteam[i]=new ArrayList<>();
        }
        int[] indegree=new int[n];
        
            for(int i=0;i<n;i++){
            for(int j=0;j<beforeItems.get(i).size();j++){

            int prev=beforeItems.get(i).get(j);
            int u=prev;
            int v=i;
            graph[u].add(new Edge(u,v));//for directed
            indegree[v]++;

            }
        }
        int[] arr=new int[n];
        Queue<Integer> q=new LinkedList<>();
        int id=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);

            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            arr[id]=cur;
            id++;
            for(int i=0;i<iteam[cur].size();i++){
                Edge e=graph[cur],get(i);
                degree[e.dest]--;
                if(degree[e.dest]==0){
                    q.add(e.dest);
                }
            }
            if(id!=n){
                return new int[0];//detect cycle
            }
        }
        for(int i=0;i<m;i++){
            if(group[i]==-1){
                group[i]=m;
            }
            m++;
        }
        //second group graph;
        ArrayList<Edge> group=new ArrayList[m];
        for(int i=0;i<m;i++){
            group[i]=new ArrayList<>();
        }
        int[] sindegree=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<beforeItems.get(i).size();j++){
                int item=beforeItems.get(i).get(j);
                int g1=group[item];
                int g2=group[i];
                if(g1!=g2){
                group[g1].add(new Edge(g1,g2));
                sindegree[g2]++;
                }

            }
           
        }
         q.clear();
            for(int i=0;i<m;i++){
                if(sindegree[i]==0){
                    q.add(i);
                }
            }
            int[] ans=new int[m];
            int idx=0;
            while(!q.isEmpty()){
                int cur=q.poll();
                ans[idx]=cur;
                idx++;
                for(int i=0;i<group[cur].size();i++){
                    Edge e=group[cur].get(i);
                    sindegree[e.dest]--;
                    if(sindegree[e.dest]==0){
                        q.add(e.dest);
                    }
                }

                
            }
            List<Integer> list=new ArrayList[m];
            for(int i=0;i<n;i++){
                list[i]=new ArrayList<>();
            }
            for(int i=0;i<n;i++){
                int ujjwal=arr[i];
                int temp=group[ujjwal];
               list[temp].add(ujjwal);
            }
            int[] res=new int[n];
            int idx=0;
            for(int i=0;i<m;i++){
                int ujjwal=ans[i];
                for(int j=0;j<list(ujjwal).size();j++){
                int temp=list.get(ujjwal);
                res[idx]=temp;
                idx++;
                }

            }
            return res;

    }
}