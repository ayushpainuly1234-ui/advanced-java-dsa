import java.util.Scanner;
import java.util.*;
public class commonancestor{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }

}
public static boolean contains(node root , node same){
    if(root==null) return false;
    if(root==same) return true;
    return (contains(root.left,same)  ||  contains(root.right,same));

}
public static node ancestor(node root, node p,node q){
 if(root == null || root == p || root == q) return root;

  
   boolean leftp=contains(root.left,p);
   boolean rightq=contains(root.right,q);
   if((leftp==true  &&  rightq==true) || (!leftp  &&  !rightq)){
    return root;
   }
   if(leftp==true  &&  rightq==false){
    return ancestor(root.left,p,q);
   }
    if(leftp==false  && rightq==true){
  return  ancestor(root.right,p,q);
   }
    return root;

   

   
  
}


  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root= new node(1);
        node a=new node(2);
            node b=new node(3);
            root.left=a;
            root.right=b;
                node c=new node(4);
                node d=new node(5);
                a.left=c;
                a.right=d;
               node e=new node(6);
               b.right=e;
            node ans = ancestor(root, b, e);
        System.out.println("Common ancestor: " + ans.val);
     
    
}
}