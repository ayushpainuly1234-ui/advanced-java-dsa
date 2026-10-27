import java.util.Scanner;
import java.util.*;
public class infectionnode{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
   }
   public static node getin(node root,int start){
    if(root==null) return root;
    if(root.val==start)  return root;
  node left=  getin(root.left,start);
   node right= getin(root.right,start);
     if(left==null){
        return right;
     }
     else{
        return left;
     }


   }
   public static void preorder(node root,  Map<node,node> parant){
     if(root==null){
       return ;
     }
     if(root.left!=null)  parant.put(root.left,root); 
     if(root.right!=null) parant.put(root.right,root); 
       preorder(root.left,parant);
       preorder(root.right,parant);
     return;

   }
   public static int amouthoftime(node root,int start){
      node infected=getin(root,start);
      Map<node,node> parant=new HashMap<>();
      preorder(root,parant); 
      Map<node,Integer> visited=new HashMap<>();
      Queue<node> q=new LinkedList<>();
      q.add(infected);
      visited.put(infected,0);
    
      while(!q.isEmpty()){
         node temp=q.remove();
           int leval= visited.get(temp);
         if(temp.left!=null  &&  !visited.containsKey(temp.left)){
            q.add(temp.left);
            visited.put(temp.left,leval+1);
         }
         if(temp.right!=null  &&  !visited.containsKey(temp.right)){
            q.add(temp.right);
             visited.put(temp.right,leval+1);
         }
         if(parant.containsKey(temp)  &&  !visited.containsKey(parant.get(temp))){
            q.add(parant.get(temp));
            visited.put(parant.get(temp),leval+1);
         }
     //    q.remove();


      }
      int max=-1;
      for(int level:visited.values()){
         max=Math.max(max,level);

      }
      return max;
      

   }
  
   




  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);

        root.left.left = new node(4);
        root.left.left.left = new node(5);
        root.left.left.right = new node(6);

        root.right.left = new node(7);
        root.right.right = new node(8);
        root.right.right.left = new node(9);
        root.right.right.right = new node(10);

              int start=5;
             int ans=amouthoftime(root,start);    
             System.out.print(ans);
   
}
}