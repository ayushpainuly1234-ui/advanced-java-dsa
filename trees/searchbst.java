import java.util.Scanner;
import java.util.*;
public class searchbst{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
   }
 public static node bst(node root,int target){
      if(root==null) return root;
      if(root.val==target) return root;
      if(root.val>target){
      return  bst(root.left,target);
      }
      else{
    return  bst(root.right,target);
      }
      
     

 }
   




  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root = new node(4);
        root.left = new node(2);
        root.right = new node(7);

        root.left.left = new node(1);
       
         root.left.right=new node(3);

    int target=3;
           node ans=bst(root,target);
           System.out.print(ans.val); 
   
}

}